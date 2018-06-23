package main.java.com.exabit.Services;

import java.util.List;

/**
 * Created by Casperinous on 24/1/2016.
 */
public interface GenericService<T, K> {

    T create(T t);

    void delete(K id);

    List<T> findAll();

    T update(T T);

    T findById(K id);


}