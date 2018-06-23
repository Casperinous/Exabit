package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.UsersEntity; 
 
 
public interface UsersEntityService extends GenericService<UsersEntity, Integer> {

    UsersEntity findByusername(String username);
}