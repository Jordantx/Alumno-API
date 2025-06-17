package com.educacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="alumno")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno",nullable = false)
	private Long id_alumno;	
	
	@Column(name = "nombre",nullable = false)
	private String nombre;
	
	@Column(name = "Apellido",nullable = false)
	private String Apellido;
	
	@Column(name = "edad",nullable = false)
	private int edad;
	
	@Column(name = "sexo",nullable = false)
	private String  sexo;
	
	@Column(name = "telefono",nullable = false)
	private int telefono;
}
