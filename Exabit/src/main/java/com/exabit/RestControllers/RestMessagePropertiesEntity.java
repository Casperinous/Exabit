package main.java.com.exabit.RestControllers; 
 import main.java.com.exabit.Entities.MessagePropertiesEntity; 
 import main.java.com.exabit.Services.MessagePropertiesEntityService; 
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus; 
 import org.springframework.web.bind.annotation.*; 
 import java.util.List; 
  
 
@RestController 
@RequestMapping("api/v1/MessagePropertiesEntity") 
public class RestMessagePropertiesEntity { 
	
	@Autowired 
	MessagePropertiesEntityService Service; 
	private static final Logger LOGGER = LoggerFactory.getLogger(RestMessagePropertiesEntity.class); 
	
	@RequestMapping(method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED) 
	MessagePropertiesEntity create(@RequestBody MessagePropertiesEntity Entity){ 
		return Service.create(Entity); 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE) 
	public void delete(@PathVariable("id") int id) { 
		LOGGER.info("Deleting a MessagePropertiesEntity entry with id: {}", id); Service.delete(id); 
	} 

	@RequestMapping(method = RequestMethod.GET) 
	List<MessagePropertiesEntity> findAll() { 
		LOGGER.info("Finding all MessagePropertiesEntity entries"); 
		List<MessagePropertiesEntity> Entities = Service.findAll(); 
		LOGGER.info("Found {} MessagePropertiesEntity entries.", Entities.size()); 
		return Entities; 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT) 
	MessagePropertiesEntity update(@RequestBody MessagePropertiesEntity Entity) { 
		LOGGER.info("Updating the information of a MessagePropertiesEntity entry by using information: {}", Entity); MessagePropertiesEntity 
		updated = Service.update(Entity); 
		LOGGER.info("Updated the information of the MessagePropertiesEntity entrY: {}", updated); 
		return updated; 
	}
}