package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.PrivateKeyEntity; 
import main.java.com.exabit.Repositories.PrivateKeyEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class PrivateKeyEntityServiceImpl implements PrivateKeyEntityService { 
 
private static final Logger LOGGER = LoggerFactory.getLogger(PrivateKeyEntityServiceImpl.class); 

    @Resource
    private PrivateKeyEntityRepository repository;
 
    public PrivateKeyEntity create(PrivateKeyEntity privatekeyentity) {return repository.save(privatekeyentity);
 } 

    public void delete(Integer id) {
        repository.delete(id); 
 } 

    public List<PrivateKeyEntity> findAll() {
        return (List<PrivateKeyEntity>) repository.findAll(); 
} 

    public PrivateKeyEntity findById(Integer id) {
        return repository.findOne(id);
    }

    public PrivateKeyEntity update(PrivateKeyEntity privatekeyentity) {
        return repository.save(privatekeyentity); 
 }

    public List<PrivateKeyEntity> findByfromUserId(int fromUserId) {
        return repository.findByidUsers(fromUserId);
    }
}
