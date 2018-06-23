package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersEntityRepository extends JpaRepository<UsersEntity, Integer> {

    //uid
    UsersEntity findByuid(String uid);

    UsersEntity findByusername(String username);

}