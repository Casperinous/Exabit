package main.java.com.exabit.Repositories;


import main.java.com.exabit.Entities.FriendRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FriendRequestEntityRepository extends JpaRepository<FriendRequestEntity, Integer> {

    List<FriendRequestEntity> findByfromUserId(int fromUserId);

    List<FriendRequestEntity> findBytoUserId(int toUserId);

    FriendRequestEntity findByFromUserIdAndToUserId(int fromUserId, int toUserId);
}