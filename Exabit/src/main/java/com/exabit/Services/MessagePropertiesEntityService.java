package main.java.com.exabit.Services; 
import main.java.com.exabit.Entities.MessagePropertiesEntity;

import java.util.List;


public interface MessagePropertiesEntityService extends GenericService<MessagePropertiesEntity, Integer> {

    List<MessagePropertiesEntity> findByidMessageAndidUser(int idMessage, int idUser);

    Long countByidUser(int idUser);

    List<MessagePropertiesEntity> findByIdUser(int idUser);

}