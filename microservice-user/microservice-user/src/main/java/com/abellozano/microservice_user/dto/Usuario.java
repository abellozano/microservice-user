package com.abellozano.microservice_user.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "usuarios")
@Entity
public class Usuario {
    
    @Id
    @JsonProperty("dni")
    private Long dni;

    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("apellidos")
    private String apellidos;
    
    @JsonProperty("edad")
    private Integer edad;
    
    public Usuario(String nombre, String apellidos, Integer edad)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad; 
        
    }
    
    public Usuario(){
    }
    

    
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

   
}