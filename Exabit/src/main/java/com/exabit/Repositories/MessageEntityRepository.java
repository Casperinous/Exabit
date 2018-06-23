package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageEntityRepository extends JpaRepository<MessageEntity, Integer> {

    List<MessageEntity> findByfromUserId(int fromUserId);

    List<MessageEntity> findBytoUserId(int toUserId);

}