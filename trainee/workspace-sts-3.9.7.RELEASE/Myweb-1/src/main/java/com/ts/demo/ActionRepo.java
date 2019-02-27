package com.ts.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="action",path="action")
public interface ActionRepo extends JpaRepository<Action,Integer> {

}
