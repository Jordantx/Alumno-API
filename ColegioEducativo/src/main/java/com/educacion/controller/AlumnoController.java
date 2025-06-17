package com.educacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacion.dto.AlumnoDTO;
import com.educacion.model.Alumno;
import com.educacion.service.AlumnoService;

@RestController
@RequestMapping("/alumno")


public class AlumnoController {
	
	@Autowired
	private AlumnoService  alumnoService;
	
	//POST
	@PostMapping
	public ResponseEntity<AlumnoDTO> crear(@RequestBody AlumnoDTO alumnoDTO) {
	    AlumnoDTO createdAlumno = alumnoService.saveAlumno(alumnoDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdAlumno);
	}

	
	 //GET - listar
    @GetMapping("/list")
    public List<AlumnoDTO> getAllPaises() {
        return alumnoService.getAllAlumno();
    }
    
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno actualizado = alumnoService.actualizarAlumno(id, alumno);
        return ResponseEntity.ok(actualizado);
    }

	//DELETE 
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.ok("Alumno eliminado con éxito");
    }
    
}
