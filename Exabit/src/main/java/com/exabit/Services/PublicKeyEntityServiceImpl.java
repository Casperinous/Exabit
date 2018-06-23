package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.PublicKeyEntity; 
import main.java.com.exabit.Repositories.PublicKeyEntityRepository; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import javax.annotation.Resource; 
import java.util.List; 
 
 
@Transactional 
@Service 
public class PublicKeyEntityServiceImpl implements PublicKeyEntityService { 
 
private static final Logger LOGGER = LoggerFactory.getLogger(PublicKeyEntityServiceImpl.class); 

    @Resource
    private PublicKeyEntityRepository repository;
 
    public PublicKeyEntity create(PublicKeyEntity publickeyentity) {
 return repository.save(publickeyentity); 
 } 

    public void delete(Integer id) {
        repository.delete(id); 
 } 

    public List<PublicKeyEntity> findAll() {
        return (List<PublicKeyEntity>) repository.findAll(); 
} 

    public PublicKeyEntity findById(Integer id) {
        return repository.findOne(id);
    }
    
    public PublicKeyEntity update(PublicKeyEntity publickeyentity) {
        return repository.save(publickeyentity); 
    }

    public List<PublicKeyEntity> findByfromUserId(int fromUserId) {

        return repository.findByidUsers(fromUserId);
    }
}
