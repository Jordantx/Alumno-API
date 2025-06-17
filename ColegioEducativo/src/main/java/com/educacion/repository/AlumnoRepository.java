package com.educacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacion.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno,  Long>{

	Optional<Alumno> findById(Long id_alumno); 
	
	
}
