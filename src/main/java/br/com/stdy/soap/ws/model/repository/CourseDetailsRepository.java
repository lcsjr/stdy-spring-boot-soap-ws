package br.com.stdy.soap.ws.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stdy.soap.ws.model.Course;

@Repository
public interface CourseDetailsRepository extends JpaRepository<Course, Integer>{

	Course findById(int id);
}
