package com.sofka.biblioteca.controllers;


import com.sofka.biblioteca.dtos.ResourceDTO;
import com.sofka.biblioteca.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")

public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping("/resource/{id}")
    public ResponseEntity<ResourceDTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(resourceService.getResourceById(id), HttpStatus.OK);
    }

    @GetMapping("/resource")
    public ResponseEntity<List<ResourceDTO>> findAll() {
        return new ResponseEntity(resourceService.getResourceAll(), HttpStatus.OK);
    }

    /*@GetMapping("/resource/filter")
    public ResponseEntity<List<ResourceDTO>> findAllTypeAndThematic(@RequestParam String type, String thematic) {
        System.out.println(type + "---   " +thematic);
        return new ResponseEntity(resourceService.getResourceFilter(type,thematic), HttpStatus.OK);
    }*/

    @PostMapping("/create")
    public ResponseEntity<ResourceDTO> create(@RequestBody ResourceDTO resourceDTO) {
        return new ResponseEntity(resourceService.newResource(resourceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/prestamo")
    public ResponseEntity<ResourceDTO> load(@RequestBody ResourceDTO resourceDTO) {
        if (resourceDTO.getId()!= null) {
            return new ResponseEntity(resourceService.newLoad(resourceDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/devolucion")
    public ResponseEntity<ResourceDTO> returnResource(@RequestBody ResourceDTO resourceDTO) {
        if (resourceDTO.getId()!= null) {
            return new ResponseEntity(resourceService.returnResource(resourceDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
