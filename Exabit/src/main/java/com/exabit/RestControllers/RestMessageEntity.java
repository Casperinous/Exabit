package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.CustomUserEntity;
 import main.java.com.exabit.Entities.FriendsEntity;
 import main.java.com.exabit.Entities.MessageEntity;
 import main.java.com.exabit.Services.FriendsEntityService;
 import main.java.com.exabit.Services.MessageEntityService;
 import main.java.com.exabit.Utils.HtmlUtils;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus;
 import org.springframework.security.core.annotation.AuthenticationPrincipal;
 import org.springframework.util.Base64Utils;
 import org.springframework.web.bind.annotation.*;

 import java.io.UnsupportedEncodingException;
 import java.util.List;
  
 
@RestController 
@RequestMapping("api/v1/MessageEntity") 
public class RestMessageEntity { 

    @Autowired
    MessageEntityService Service;

    @Autowired
    FriendsEntityService friendsEntityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestMessageEntity.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    MessageEntity create(@RequestBody MessageEntity Entity, @AuthenticationPrincipal CustomUserEntity customUser){

        Entity.setFromUserId(customUser.getUserId());
        FriendsEntity friendsEntity = friendsEntityService.IsUserFriendWith(customUser.getUserId(), Entity.getToUserId());
        if( friendsEntity == null ) return new MessageEntity();

        
        return Service.create(Entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        LOGGER.info("Deleting a MessageEntity entry with id: {}", id); Service.delete(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    MessageEntity update(@RequestBody MessageEntity Entity) {
        LOGGER.info("Updating the information of a MessageEntity entry by using information: {}", Entity); MessageEntity
        updated = Service.update(Entity);
        LOGGER.info("Updated the information of the MessageEntity entrY: {}", updated);
        return updated;
    }
}