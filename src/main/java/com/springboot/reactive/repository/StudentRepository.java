package com.springboot.reactive.repository;

import com.springboot.reactive.dao.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    Flux<Student> findAllByFirstnameContainingIgnoreCase(String firstname);

}