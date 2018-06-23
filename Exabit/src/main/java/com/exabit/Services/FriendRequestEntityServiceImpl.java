package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.FriendRequestEntity; 
import main.java.com.exabit.Repositories.FriendRequestEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class FriendRequestEntityServiceImpl implements FriendRequestEntityService { 
 
private static final Logger LOGGER = LoggerFactory.getLogger(FriendRequestEntityServiceImpl.class);

    @Resource
    private FriendRequestEntityRepository repository;
 
    public FriendRequestEntity create(FriendRequestEntity friendrequestentity) {
        return repository.save(friendrequestentity);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public List<FriendRequestEntity> findAll() {
 return (List<FriendRequestEntity>) repository.findAll(); 
} 

    public FriendRequestEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public FriendRequestEntity update(FriendRequestEntity friendrequestentity) {
        return repository.save(friendrequestentity);
    }



    public List<FriendRequestEntity> findByfromUserId(int fromUserId) {

        return  repository.findByfromUserId(fromUserId);
    }


    public List<FriendRequestEntity> findBytoUserId(int toUserId) {
        return repository.findBytoUserId(toUserId);
    }


    @Override
    public FriendRequestEntity findByFromUserIdAndToUserId(int fromUserId, int toUserId) {
        return repository.findByFromUserIdAndToUserId(fromUserId,toUserId);
    }
}
