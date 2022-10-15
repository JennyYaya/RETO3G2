package com.entrega.reto3.CrudRepository;

import com.entrega.reto3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
