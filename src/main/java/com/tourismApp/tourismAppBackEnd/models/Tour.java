package com.tourismApp.tourismAppBackEnd.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tours")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Tour {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String nombre;
	private String descripcion;
	
	private Date createdAt = new Date();
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Tour() {
		super();
	}

}
