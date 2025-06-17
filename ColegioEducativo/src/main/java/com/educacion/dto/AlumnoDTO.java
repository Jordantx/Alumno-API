// esto es el alumnos de un sistema de ducativo


package com.educacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor       // un constructor con todos los atributos
@NoArgsConstructor      // Constructor vacío
public class AlumnoDTO {
	private Long id_alumno;	
	private String nombre;
	private String Apellido;
	private int edad;
	private String  sexo;
	private int telefono;
}
