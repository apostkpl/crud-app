package com.crudbasics.crudapp.repository;

import com.crudbasics.crudapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {}
// No method declarations here. Basic CRUD operations are inherited by the JpaRepository