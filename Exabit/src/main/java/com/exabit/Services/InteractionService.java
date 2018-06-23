package main.java.com.exabit.Services;


import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by nikostot on 3/9/2016.
 */
public interface InteractionService<T> {

    List<T> findByfromUserId(int fromUserId);

    List<T> findBytoUserId(int toUserId);
}
