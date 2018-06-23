package main.java.com.exabit.Services;

import main.java.com.exabit.Entities.PrivateKeyEntity;

import java.util.List;


public interface KeyService<K> {

    List<K> findByfromUserId(int fromUserId);

}
