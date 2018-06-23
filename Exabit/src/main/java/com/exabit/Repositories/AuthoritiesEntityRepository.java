package main.java.com.exabit.Repositories;

import main.java.com.exabit.Entities.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nikostot on 4/9/2016.
 */
public interface AuthoritiesEntityRepository extends JpaRepository<AuthoritiesEntity,Integer> {

    AuthoritiesEntity findByNumber(int number);

}
