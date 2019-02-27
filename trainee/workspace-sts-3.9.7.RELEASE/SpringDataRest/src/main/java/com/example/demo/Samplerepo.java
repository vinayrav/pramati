package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="sam",path="sam")
public interface Samplerepo extends JpaRepository<Sample, Integer> {

}
