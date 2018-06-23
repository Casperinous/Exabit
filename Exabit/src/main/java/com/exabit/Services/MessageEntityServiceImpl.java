package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.FriendsEntity;
import main.java.com.exabit.Entities.MessageEntity;
import main.java.com.exabit.Repositories.MessageEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class MessageEntityServiceImpl implements MessageEntityService { 
 
private static final Logger LOGGER = LoggerFactory.getLogger(MessageEntityServiceImpl.class);

    @Resource
    private MessageEntityRepository repository;
 

    public MessageEntity create(MessageEntity messageentity) {
 return repository.save(messageentity); 
 } 

    public void delete(Integer id) {
 repository.delete(id); 
 } 

    public List<MessageEntity> findAll() {
 return (List<MessageEntity>) repository.findAll(); 
} 

    public MessageEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public MessageEntity update(MessageEntity messageentity) {
 return repository.save(messageentity); 
 }


    @Override
    public List<MessageEntity> findByfromUserId(int fromUserId) {
        return repository.findByfromUserId(fromUserId);
    }

    @Override
    public List<MessageEntity> findBytoUserId(int toUserId) {
        return repository.findBytoUserId(toUserId);
    }
}
