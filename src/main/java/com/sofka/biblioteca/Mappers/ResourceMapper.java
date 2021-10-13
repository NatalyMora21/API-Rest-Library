package com.sofka.biblioteca.Mappers;

import com.sofka.biblioteca.collections.Resource;
import com.sofka.biblioteca.dtos.ResourceDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceMapper {

    public Resource fromDTO(ResourceDTO dto) {

        Resource resource = new Resource();
        resource.setId(dto.getId());
        resource.setTitle(dto.getTitle());
        resource.setType(dto.getType());
        resource.setThematic(dto.getThematic());
        resource.setAvailable(dto.getAvailable());
        resource.setDate(dto.getDate());

        return resource;
    }

    public ResourceDTO fromCollection(Resource collection){

        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setId(collection.getId());
        resourceDTO.setTitle(collection.getTitle());
        resourceDTO.setType(collection.getType());
        resourceDTO.setThematic(collection.getThematic());
        resourceDTO.setAvailable(collection.getAvailable());
        resourceDTO.setDate(collection.getDate());

        return resourceDTO;
    }

    public List<ResourceDTO> fromCollectionList(List<Resource> collection) {

        if (collection == null) {
            return null;

        }
        List<ResourceDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Resource resource = (Resource) listTracks.next();
            list.add(fromCollection(resource));
        }

        return list;
    }


}
