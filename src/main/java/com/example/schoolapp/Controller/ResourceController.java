package com.example.schoolapp.Controller;

import com.example.schoolapp.Models.Resource;
import com.example.schoolapp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/details/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource) {
        Resource addedResource = resourceService.addResource(resource);
        return new ResponseEntity<>(addedResource, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        Resource updatedResource = resourceService.updateResource(id, resource);
        return new ResponseEntity<>(updatedResource, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stats/quantityByName/{name}")
    public ResponseEntity<Long> getResourceQuantityByName(@PathVariable String name) {
        long quantity = resourceService.getResourceQuantityByName(name);
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @GetMapping("/stats/totalCost")
    public ResponseEntity<Double> getTotalCostOfAllResources() {
        double totalCost = resourceService.getTotalCostOfAllResources();
        return new ResponseEntity<>(totalCost, HttpStatus.OK);
    }

    @GetMapping("/stats/available")
    public ResponseEntity<List<Resource>> getAllAvailableResources() {
        List<Resource> availableResources = resourceService.getAllAvailableResources();
        return new ResponseEntity<>(availableResources, HttpStatus.OK);
    }
}
