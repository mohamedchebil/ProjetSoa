package com.example.schoolapp.service;

import com.example.schoolapp.Models.Resource;

import java.util.List;

public interface ResourceService {
    Resource getResourceById(Long id);
    List<Resource> getAllResources();
    Resource addResource(Resource resource);
    Resource updateResource(Long id, Resource resource);
    void deleteResource(Long id);

    long getResourceQuantityByName(String name);
    double getTotalCostOfAllResources();
    List<Resource> getAllAvailableResources();

}
