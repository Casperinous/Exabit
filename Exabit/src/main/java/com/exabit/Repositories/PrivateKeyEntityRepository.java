package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.PrivateKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PrivateKeyEntityRepository extends JpaRepository<PrivateKeyEntity, Integer> {

    List<PrivateKeyEntity> findByidUsers(int idUsers);


}