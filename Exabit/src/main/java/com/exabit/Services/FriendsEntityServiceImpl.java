package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.FriendsEntity; 
import main.java.com.exabit.Repositories.FriendsEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class FriendsEntityServiceImpl implements FriendsEntityService { 
 
    private static final Logger LOGGER = LoggerFactory.getLogger(FriendsEntityServiceImpl.class);

    @Resource
    private FriendsEntityRepository repository;
 

    public FriendsEntity create(FriendsEntity friendsentity) {
 return repository.save(friendsentity); 
 } 

    public void delete(Integer id) {
 repository.delete(id); 
 } 

    public List<FriendsEntity> findAll() {
 return (List<FriendsEntity>) repository.findAll(); 
} 

    public FriendsEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public FriendsEntity update(FriendsEntity friendsentity) {
 return repository.save(friendsentity); 
 }


    @Override
    public List<FriendsEntity> findByfromUserId(int fromUserId) {
        return repository.findBytoUserId(fromUserId);
    }

    @Override
    public List<FriendsEntity> findBytoUserId(int toUserId) {
        return repository.findBytoUserId(toUserId);
    }

    @Override
    public FriendsEntity IsUserFriendWith(int userId_1, int userId_2) {
        return repository.IsFriendShipExists(userId_1, userId_2);
    }
}
