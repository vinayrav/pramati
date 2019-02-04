package com.practice.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//public interface DataRepo extends CrudRepository<Data, Integer> 
public interface DataRepo extends JpaRepository<Data, Integer> {

}
