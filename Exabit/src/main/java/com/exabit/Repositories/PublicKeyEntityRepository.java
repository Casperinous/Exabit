package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.PublicKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PublicKeyEntityRepository extends JpaRepository<PublicKeyEntity, Integer> {

    List<PublicKeyEntity> findByidUsers(int idUsers);

}