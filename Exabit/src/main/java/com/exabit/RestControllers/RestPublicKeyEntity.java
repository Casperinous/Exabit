package main.java.com.exabit.RestControllers; 
import main.java.com.exabit.Entities.CustomUserEntity;
import main.java.com.exabit.Entities.PublicKeyEntity;
import main.java.com.exabit.Entities.UsersEntity;
import main.java.com.exabit.Services.PublicKeyEntityService;
import main.java.com.exabit.Services.UsersEntityService;
import main.java.com.exabit.Utils.HtmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
  
 
@RestController 
@RequestMapping("api/v1/PublicKeyEntity") 

public class RestPublicKeyEntity {

    @Autowired
    PublicKeyEntityService Service;

    @Autowired
    UsersEntityService usersEntityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestPublicKeyEntity.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    PublicKeyEntity create(@RequestBody PublicKeyEntity Entity, @AuthenticationPrincipal CustomUserEntity customUserEntity){

        UsersEntity user = usersEntityService.findById(customUserEntity.getUserId());

        if( user == null ) return null;

        List<PublicKeyEntity> keys = Service.findByfromUserId(customUserEntity.getUserId());


        if( user.getIdAuthority() == 1 && keys.size() == 1 )
            return null;

        //Fix Keys Properties
        Entity.setIdUsers(user.getIdUsers());
        /*
        String cleaned = HtmlUtils.CleanFromHtml(Entity.getPublicKey(), true);
        Entity.setPublicKey(cleaned);
        */

        return Service.create(Entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        LOGGER.info("Deleting a PublicKeyEntity entry with id: {}", id); Service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<PublicKeyEntity> findAll() {
        LOGGER.info("Finding all PublicKeyEntity entries");
        List<PublicKeyEntity> Entities = Service.findAll();
        LOGGER.info("Found {} PublicKeyEntity entries.", Entities.size());
        return Entities;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    PublicKeyEntity update(@RequestBody PublicKeyEntity Entity) {
        LOGGER.info("Updating the information of a PublicKeyEntity entry by using information: {}", Entity); PublicKeyEntity
        updated = Service.update(Entity);
        LOGGER.info("Updated the information of the PublicKeyEntity entrY: {}", updated);
        return updated;
    }
}