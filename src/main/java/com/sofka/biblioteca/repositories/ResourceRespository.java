package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.collections.Resource;
import com.sofka.biblioteca.collections.values.Thematic;
import com.sofka.biblioteca.collections.values.Type;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRespository extends MongoRepository <Resource , String> {

    List<Resource> findByType(Type type);

    List<Resource> findByThematic(Thematic history);
}
