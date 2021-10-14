package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.collections.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRespository extends MongoRepository <Resource , String> {

}
