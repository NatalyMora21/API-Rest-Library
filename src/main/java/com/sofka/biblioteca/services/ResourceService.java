package com.sofka.biblioteca.services;

import com.sofka.biblioteca.Mappers.ResourceMapper;
import com.sofka.biblioteca.collections.Resource;
import com.sofka.biblioteca.dtos.ResourceDTO;
import com.sofka.biblioteca.repositories.ResourceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    ResourceRespository resourceRespository;
    ResourceMapper mapper = new ResourceMapper();


    public ResourceDTO getResourceById(String id) {
        Resource resource = resourceRespository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        return mapper.fromCollection(resource);
    }

    public List<ResourceDTO> getResourceAll() {
        List<Resource> resource = resourceRespository.findAll();
        return mapper.fromCollectionList(resource);
    }

    public ResourceDTO newResource(ResourceDTO resourceDTO){
        Resource resource = mapper.fromDTO(resourceDTO);
        resource.setLending(0);
        return mapper.fromCollection(resourceRespository.save(resource));
    }

    public ResourceDTO newLoad(ResourceDTO resourceDTO) {

        Resource resource = mapper.fromDTO(resourceDTO);
        Resource infoResource = resourceRespository.findById(resource.getId()).orElseThrow(() -> new RuntimeException("Resource not found"));

        //prestamos, solo de a un libro;
        if(infoResource.getStock()>0) {
            infoResource.setStock(infoResource.getStock()-1);
            infoResource.setLending(infoResource.getLending()+1);
            infoResource.setDate(LocalDate.now());
        }

        return mapper.fromCollection(resourceRespository.save(infoResource));
        //Retornar que no se puedo hacer la operación por falta de stock
    }

    public ResourceDTO returnResource(ResourceDTO resourceDTO) {

        Resource resource = mapper.fromDTO(resourceDTO);
        Resource infoResource = resourceRespository.findById(resource.getId()).orElseThrow(() -> new RuntimeException("Resource not found"));
        if(infoResource.getLending()>0) {
            infoResource.setStock(infoResource.getStock()+1);
            infoResource.setLending(infoResource.getLending()-1);
        }

        return mapper.fromCollection(resourceRespository.save(infoResource));
    }


    /*public List<ResourceDTO> getResourceFilter(String type, String thematic) {


    }*/
}
