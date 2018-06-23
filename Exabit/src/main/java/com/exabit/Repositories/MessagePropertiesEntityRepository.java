package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.MessagePropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessagePropertiesEntityRepository extends JpaRepository<MessagePropertiesEntity, Integer> {

    List<MessagePropertiesEntity> findByIdMessageAndIdUser(int idMessage, int idUser);

    List<MessagePropertiesEntity> findByIdUser(int idUser);

    Long countByidUser(int idUser);


}