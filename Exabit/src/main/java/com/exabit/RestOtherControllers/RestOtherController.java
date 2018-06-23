package main.java.com.exabit.RestOtherControllers;

import main.java.com.exabit.Entities.*;
import main.java.com.exabit.OtherEntities.MailBoxInfo;
import main.java.com.exabit.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nikostot on 4/9/2016.
 */

@RestController
@RequestMapping("api/v1/")
public class RestOtherController {

    @Autowired
    PublicKeyEntityService publicKeyEntityService;

    @Autowired
    PrivateKeyEntityService privateKeyEntityService;

    @Autowired
    UsersEntityService usersEntityService;

    @Autowired
    FriendRequestEntityService friendRequestEntityService;

    @Autowired
    MessagePropertiesEntityService messagePropertiesEntityService;

    @Autowired
    MessageEntityService messageEntityService;

    @Autowired
    FriendsEntityService friendsEntityService;

    @RequestMapping(value = "/GetMyMails", method = RequestMethod.GET)
    List<MessageEntity> GetMyMails(@AuthenticationPrincipal CustomUserEntity customUser) {

        return messageEntityService.findBytoUserId(customUser.getUserId());
    }

    @RequestMapping(value = "/GetFriendRequestsToMe", method = RequestMethod.GET)
    List<FriendRequestEntity> GetFriendRequestsToMe(@AuthenticationPrincipal CustomUserEntity customUser) {

        return friendRequestEntityService.findBytoUserId(customUser.getUserId());
    }

    @RequestMapping(value = "/GetUsernameFromId", method = RequestMethod.POST)
    String GetUsernameFromId(@RequestParam(value = "id") int id, @AuthenticationPrincipal CustomUserEntity customUser) {

        if (id <= 0) return "Error";

        /* Check if the user searching for the id has any relationship with it */
        List<FriendRequestEntity> reqs = friendRequestEntityService.findBytoUserId(customUser.getUserId());

        if( reqs == null || reqs.size() == 0 ) return "Error";

        UsersEntity fr = usersEntityService.findById(id);

        return fr != null ? fr.getUsername() : new String();
    }

    @RequestMapping(value = "/GetMailBoxInfo", method = RequestMethod.GET)
    MailBoxInfo GetMailBoxInfo(@AuthenticationPrincipal CustomUserEntity customUser) {

        List<MessagePropertiesEntity> messagePropertiesEntities = messagePropertiesEntityService.findByIdUser(customUser.getUserId());

        int unread = messagePropertiesEntities.stream()
                .filter(property -> property.isSeen() == false)	
                .collect(Collectors.toList()).size();
        int draft = messagePropertiesEntities.stream()
                .filter(property -> property.isDraft() == false)	
                .collect(Collectors.toList()).size();

        MailBoxInfo mailBoxInfo = new MailBoxInfo();
        mailBoxInfo.setInbox(unread);
        mailBoxInfo.setDrafts(draft);

        return mailBoxInfo;

    }


    @RequestMapping(value = "/PublicKeys", method = RequestMethod.GET)
    List<PublicKeyEntity> GetPublicKeys(@AuthenticationPrincipal CustomUserEntity customUser) {

        return publicKeyEntityService.findByfromUserId(customUser.getUserId());
    }

    @RequestMapping(value = "/GetRecipientPK", method = RequestMethod.POST)
    List<PublicKeyEntity> GetRecipientPK(@RequestParam(value = "id") int id, @AuthenticationPrincipal CustomUserEntity customUser) {

        List<PublicKeyEntity> keys = new ArrayList<>();

        if( id <= 0 ) return keys;

        //Should be one
        FriendsEntity friendsEntity = friendsEntityService.IsUserFriendWith(customUser.getUserId(), id);

        if( friendsEntity == null) return keys;

        return publicKeyEntityService.findByfromUserId(id)
                                     .stream()
                                     .filter(publicKeyEntity-> publicKeyEntity.isVisible() == true)
                                     .collect(Collectors.toList());
    }



    @RequestMapping(value = "/PrivateKeys", method = RequestMethod.GET)
    List<PrivateKeyEntity> GetPrivateKeys(@AuthenticationPrincipal CustomUserEntity customUser) {

        return privateKeyEntityService.findByfromUserId(customUser.getUserId());
    }


    @RequestMapping(value = "/SendFriendRequest", method = RequestMethod.POST)
    String SendFriendRequest(@RequestParam(value = "username") String username, @AuthenticationPrincipal CustomUserEntity customUser) {

        if( username == null || username.isEmpty() ) return "Please Provide a valid username";

        if(username.equals( customUser.getUsername())) return "Invito yoself?";

        UsersEntity user = usersEntityService.findByusername(username);

        if( user == null ) return "Could not find User";

        //Does it exist?

        FriendRequestEntity re = friendRequestEntityService.findByFromUserIdAndToUserId(customUser.getUserId(), user.getIdUsers());

        if( re != null ) return "Already sent a request! ";

        if(friendsEntityService.IsUserFriendWith(user.getIdUsers(), customUser.getUserId()) != null ||
                friendsEntityService.IsUserFriendWith(customUser.getUserId(), user.getIdUsers()) != null
                ) return "Already friends !";


        FriendRequestEntity requestEntity = new FriendRequestEntity();
        requestEntity.setFromUserId(customUser.getUserId());
        requestEntity.setToUserId(user.getIdUsers());
        requestEntity.setAccepted(false);

        friendRequestEntityService.create(requestEntity);

        return "Friend Request was sent to" + username;

    }

}
