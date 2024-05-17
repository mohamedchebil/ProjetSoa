package com.example.schoolapp.Repo;

import com.example.schoolapp.Models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByStatus(String available);


    Arrays findByname(String name);

    @Query("SELECT SUM(r.quantity) FROM Resource r WHERE r.name = :name")
    Long getTotalQuantityByName(@Param("name") String name);
}
