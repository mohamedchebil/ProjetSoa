package com.example.schoolapp.service.serviceImpl;

import com.example.schoolapp.Models.Resource;
import com.example.schoolapp.Repo.ResourceRepository;
import com.example.schoolapp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource updateResource(Long id, Resource resource) {
        if (!resourceRepository.existsById(id)) {
            System.out.println("id null");
        }
        resource.setId(id); // Ensure the ID is set correctly
        return resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(Long id) {
        if (!resourceRepository.existsById(id)) {
            System.out.println("id null");
        }
        resourceRepository.deleteById(id);
    }
    @Override
    public long getResourceQuantityByName(String name) {
        return resourceRepository.getTotalQuantityByName(name);
    }

    @Override
    public double getTotalCostOfAllResources() {
        return resourceRepository.findAll().stream()
                .mapToDouble(Resource::getCost)
                .sum();
    }

    @Override
    public List<Resource> getAllAvailableResources() {
        return resourceRepository.findByStatus("Available");
    }






}
