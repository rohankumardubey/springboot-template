package com.clairvoyant.springboottemplate.db.repositories;

import org.springframework.data.repository.CrudRepository;
import com.clairvoyant.springboottemplate.db.entities.MessageDO;


public interface MessageRepository extends CrudRepository<MessageDO, Long> {
}
