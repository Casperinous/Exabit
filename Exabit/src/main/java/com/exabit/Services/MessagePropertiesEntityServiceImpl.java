package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.MessagePropertiesEntity; 
import main.java.com.exabit.Repositories.MessagePropertiesEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class MessagePropertiesEntityServiceImpl implements MessagePropertiesEntityService { 
 
private static final Logger LOGGER = LoggerFactory.getLogger(MessagePropertiesEntityServiceImpl.class);

    @Resource
    private MessagePropertiesEntityRepository repository;
 
    public MessagePropertiesEntity create(MessagePropertiesEntity messagepropertiesentity) {
        return repository.save(messagepropertiesentity);
    }

    public void delete(Integer id) {
 repository.delete(id); 
 } 

    public List<MessagePropertiesEntity> findAll() {
 return (List<MessagePropertiesEntity>) repository.findAll(); 
} 

    public MessagePropertiesEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public MessagePropertiesEntity update(MessagePropertiesEntity messagepropertiesentity) {
        return repository.save(messagepropertiesentity);
    }

    public List<MessagePropertiesEntity> findByidMessageAndidUser(int idMessage, int idUser) {
        return repository.findByIdMessageAndIdUser(idMessage,idUser);
    }

    @Override
    public Long countByidUser(int idUser) {
        return repository.countByidUser(idUser);
    }

    @Override
    public List<MessagePropertiesEntity> findByIdUser(int idUser) {
        return repository.findByIdUser(idUser);
    }
}
