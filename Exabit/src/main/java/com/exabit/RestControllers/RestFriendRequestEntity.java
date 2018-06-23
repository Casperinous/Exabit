package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.CustomUserEntity;
 import main.java.com.exabit.Entities.FriendRequestEntity;
 import main.java.com.exabit.Entities.FriendsEntity;
 import main.java.com.exabit.Entities.UsersEntity;
 import main.java.com.exabit.Services.FriendRequestEntityService;
 import main.java.com.exabit.Services.FriendsEntityService;
 import main.java.com.exabit.Services.UsersEntityService;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus;
 import org.springframework.security.core.annotation.AuthenticationPrincipal;
 import org.springframework.web.bind.annotation.*;
 import java.util.List; 
  
 
@RestController 
@RequestMapping("api/v1/FriendRequestEntity") 
public class RestFriendRequestEntity {

    @Autowired
    FriendRequestEntityService Service;

    @Autowired
    UsersEntityService usersEntityService;

    @Autowired
    FriendsEntityService friendsEntityService;

    @Autowired
    FriendRequestEntityService friendRequestEntityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestFriendRequestEntity.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    FriendRequestEntity create(@RequestBody FriendRequestEntity Entity, @AuthenticationPrincipal CustomUserEntity customUserEntity){

        return Service.create(Entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {

        LOGGER.info("Deleting a FriendRequestEntity entry with id: {}", id); Service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<FriendRequestEntity> findAll() {

        LOGGER.info("Finding all FriendRequestEntity entries");
        List<FriendRequestEntity> Entities = Service.findAll();
        LOGGER.info("Found {} FriendRequestEntity entries.", Entities.size());

        return Entities;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    FriendRequestEntity update(@RequestBody FriendRequestEntity Entity, @AuthenticationPrincipal CustomUserEntity customUser) {

        UsersEntity user = usersEntityService.findById(customUser.getUserId());
        FriendsEntity nfriends = null;

        if( user == null ) return null;

        if( Entity.getToUserId() == customUser.getUserId()){

            if(Entity.isAccepted()) {

                FriendsEntity friendsEntity = new FriendsEntity();
                friendsEntity.setFromUserId(Entity.getFromUserId());
                friendsEntity.setToUserId(customUser.getUserId());

                //Create FriendShip
                nfriends = friendsEntityService.create(friendsEntity);
                //DeleteRequest
                friendRequestEntityService.delete(Entity.getIdFriendRequest());
            } else {

                friendRequestEntityService.delete(Entity.getIdFriendRequest());
            }
            return nfriends != null ? new FriendRequestEntity() : null;
        }

        return null;


    }
}