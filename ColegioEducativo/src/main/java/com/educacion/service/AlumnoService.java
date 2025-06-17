package com.educacion.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.educacion.ColegioEducativoApplication;
import com.educacion.dto.AlumnoDTO;
import com.educacion.model.Alumno;
import com.educacion.repository.AlumnoRepository;

@Service
public class AlumnoService {

	
    private final ColegioEducativoApplication colegioEducativoApplication;
	@Autowired
	private AlumnoRepository alumnoRepository;

    AlumnoService(ColegioEducativoApplication colegioEducativoApplication) {
        this.colegioEducativoApplication = colegioEducativoApplication;
    }
	
	public AlumnoDTO saveAlumno(AlumnoDTO alumnoDTO) {
		Alumno alumno= new Alumno();
		alumno.setNombre(alumnoDTO.getNombre());
		alumno.setApellido(alumnoDTO.getApellido());
		alumno.setSexo(alumnoDTO.getSexo());
		alumno.setEdad(alumnoDTO.getEdad());
		alumno.setTelefono(alumnoDTO.getTelefono());
		
		Alumno saveAlumno = alumnoRepository.save(alumno) ;
		alumnoDTO.setId_alumno(saveAlumno.getId_alumno());
		
		return alumnoDTO;		
	} 
	

	
	private AlumnoDTO convertirAAlumnoDTO(Alumno alumno) {
		return new AlumnoDTO(
				alumno.getId_alumno(),
				alumno.getNombre(),
				alumno.getApellido(),
				alumno.getEdad(),
				alumno.getSexo(),
				alumno.getTelefono()
		);
		
	}
		
		public List<AlumnoDTO> getAllAlumno(){
			List<Alumno> alumno = alumnoRepository.findAll();
	        return alumno.stream()
	        		   .map(this::convertirAAlumnoDTO) 
	        	        .collect(Collectors.toList());
		
		}
		
		
//PUT
		 public Alumno actualizarAlumno(Long id, Alumno nuevoAlumno) {
		        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
		        if (!alumnoOptional.isPresent()) {
		            throw new RuntimeException("Alumno no encontrado con ID: " + id);
		        }

		        Alumno existente = alumnoOptional.get();
		        existente.setNombre(nuevoAlumno.getNombre());
		        existente.setApellido(nuevoAlumno.getApellido());
		        existente.setEdad(nuevoAlumno.getEdad());
		        existente.setSexo(nuevoAlumno.getSexo());
		        existente.setTelefono(nuevoAlumno.getTelefono());

		        return alumnoRepository.save(existente);
		    }
	
		 // DELETE 
		 public void eliminarAlumno(Long id) {
		        if (!alumnoRepository.existsById(id)) {
		            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado con ID: " + id);
		        }

		        alumnoRepository.deleteById(id);
		    }
		
}
