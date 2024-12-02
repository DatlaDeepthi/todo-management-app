package com.tms.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.app.entity.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {

}
