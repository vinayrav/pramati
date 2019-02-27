package com.ts.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="book",path="book")
public interface BookRepo extends JpaRepository<Book, Integer> {

}
