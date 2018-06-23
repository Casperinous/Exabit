package main.java.com.exabit.Repositories;



import main.java.com.exabit.Entities.FriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface FriendsEntityRepository extends JpaRepository<FriendsEntity, Integer> {

    List<FriendsEntity> findByfromUserId(int fromUserId);

    List<FriendsEntity> findBytoUserId(int toUserId);

    FriendsEntity findByFromUserIdAndToUserId(int fromUserId, int toUserId);

    @Query("SELECT p FROM FriendsEntity p WHERE ( p.fromUserId = :fromUserId AND p.toUserId = :toUserId ) OR ( p.fromUserId = :toUserId AND p.toUserId = :fromUserId )")
    FriendsEntity IsFriendShipExists(@Param("fromUserId") int fromUserId, @Param("toUserId") int toUserId );

}