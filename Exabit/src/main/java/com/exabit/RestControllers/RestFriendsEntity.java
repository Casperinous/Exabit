package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.FriendsEntity; 
 import main.java.com.exabit.Services.FriendsEntityService; 
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus; 
 import org.springframework.web.bind.annotation.*; 
 import java.util.List; 
  
 
@RestController 
@RequestMapping("api/v1/FriendsEntity") 
public class RestFriendsEntity { 

	@Autowired 
	FriendsEntityService Service; 

	private static final Logger LOGGER = LoggerFactory.getLogger(RestFriendsEntity.class); 

	@RequestMapping(method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED) 
	FriendsEntity create(@RequestBody FriendsEntity Entity){
		return Service.create(Entity); 
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE) 
	public void delete(@PathVariable("id") int id) { 
		LOGGER.info("Deleting a FriendsEntity entry with id: {}", id); 
		Service.delete(id); 
	} 

	@RequestMapping(method = RequestMethod.GET) 
	List<FriendsEntity> findAll() { 
		LOGGER.info("Finding all FriendsEntity entries"); 
		List<FriendsEntity> Entities = Service.findAll(); 
		LOGGER.info("Found {} FriendsEntity entries.", Entities.size()); 
		return Entities; 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT) 
	FriendsEntity update(@RequestBody FriendsEntity Entity) { 
		LOGGER.info("Updating the information of a FriendsEntity entry by using information: {}", Entity); FriendsEntity 
		updated = Service.update(Entity); 
		LOGGER.info("Updated the information of the FriendsEntity entrY: {}", updated); 
		return updated; 
	}
}