package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.collections.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RespositoryResource extends MongoRepository <Resource , String> {
}
