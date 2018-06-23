package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.CustomUserEntity;
 import main.java.com.exabit.Entities.PrivateKeyEntity;
 import main.java.com.exabit.Entities.UsersEntity;
 import main.java.com.exabit.Services.PrivateKeyEntityService;
 import main.java.com.exabit.Services.UsersEntityService;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus;
 import org.springframework.security.core.annotation.AuthenticationPrincipal;
 import org.springframework.web.bind.annotation.*;
 import java.util.List; 
  
 
@RestController 
@RequestMapping("api/v1/PrivateKeyEntity") 
public class RestPrivateKeyEntity { 

    @Autowired
    PrivateKeyEntityService Service;

    @Autowired
    UsersEntityService usersEntityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestPrivateKeyEntity.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    PrivateKeyEntity create(@RequestBody PrivateKeyEntity Entity ,@AuthenticationPrincipal CustomUserEntity customUserEntity){

        UsersEntity user = usersEntityService.findById(customUserEntity.getUserId());

        if( user == null ) return null;

        List<PrivateKeyEntity> keys = Service.findByfromUserId(customUserEntity.getUserId());

        if( user.getIdAuthority() == 1 && keys.size() == 1 )
            return null;

        //Fix Keys Properties
        Entity.setIdUsers(user.getIdUsers());

        return Service.create(Entity);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        LOGGER.info("Deleting a PrivateKeyEntity entry with id: {}", id); Service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<PrivateKeyEntity> findAll() {
        LOGGER.info("Finding all PrivateKeyEntity entries");
        List<PrivateKeyEntity> Entities = Service.findAll();
        LOGGER.info("Found {} PrivateKeyEntity entries.", Entities.size());
        return Entities;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    PrivateKeyEntity update(@RequestBody PrivateKeyEntity Entity) {

        LOGGER.info("Updating the information of a PrivateKeyEntity entry by using information: {}", Entity); PrivateKeyEntity
        updated = Service.update(Entity);
        LOGGER.info("Updated the information of the PrivateKeyEntity entrY: {}", updated);
        return updated;
    }
}