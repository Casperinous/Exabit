package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.FriendsEntity; 
 
 
public interface FriendsEntityService extends GenericService<FriendsEntity, Integer>, InteractionService<FriendsEntity> {

    FriendsEntity IsUserFriendWith(int userId_1, int userId_2 );
}