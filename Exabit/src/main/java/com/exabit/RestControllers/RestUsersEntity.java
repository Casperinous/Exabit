package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.UsersEntity; 
 import main.java.com.exabit.Services.UsersEntityService; 
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus; 
 import org.springframework.web.bind.annotation.*; 
 import java.util.List; 
  
 
@RestController 
@RequestMapping("api/v1/UsersEntity") 
public class RestUsersEntity { 

	@Autowired 
	UsersEntityService Service; 
	private static final Logger LOGGER = LoggerFactory.getLogger(RestUsersEntity.class); 

	@RequestMapping(method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED) 
	UsersEntity create(@RequestBody UsersEntity Entity){ 
		return Service.create(Entity); 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE) 
	public void delete(@PathVariable("id") int id) { 
		LOGGER.info("Deleting a UsersEntity entry with id: {}", id); Service.delete(id); 
	} 

	@RequestMapping(method = RequestMethod.GET) 
	List<UsersEntity> findAll() { 
		LOGGER.info("Finding all UsersEntity entries"); 
		List<UsersEntity> Entities = Service.findAll(); 
		LOGGER.info("Found {} UsersEntity entries.", Entities.size()); 
		return Entities; 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT) 
	UsersEntity update(@RequestBody UsersEntity Entity) { 
		LOGGER.info("Updating the information of a UsersEntity entry by using information: {}", Entity); UsersEntity 
		updated = Service.update(Entity); 
		LOGGER.info("Updated the information of the UsersEntity entrY: {}", updated); 
		return updated; 
	}
}