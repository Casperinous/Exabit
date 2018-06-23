package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.FriendRequestEntity;

import java.util.List;


public interface FriendRequestEntityService extends GenericService<FriendRequestEntity, Integer>, InteractionService<FriendRequestEntity> {

    FriendRequestEntity findByFromUserIdAndToUserId(int fromUserId, int toUserId);


}