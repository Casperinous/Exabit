package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.UsersEntity; 
import main.java.com.exabit.Repositories.UsersEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class UsersEntityServiceImpl implements UsersEntityService { 
 

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersEntityServiceImpl.class);

    @Resource
    private UsersEntityRepository repository;
 

    public UsersEntity create(UsersEntity usersentity) {
 return repository.save(usersentity); 
 } 

    public void delete(Integer id) {
 repository.delete(id); 
 } 

    public List<UsersEntity> findAll() {
 return (List<UsersEntity>) repository.findAll(); 
} 

    public UsersEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public UsersEntity update(UsersEntity usersentity) {
 return repository.save(usersentity); 
 }

    @Override
    public UsersEntity findByusername(String username) {
        return repository.findByusername(username);
    }
}
