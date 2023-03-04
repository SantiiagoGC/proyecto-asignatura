package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Entity
public class Persona {
    @Id
    private String cedula;
    private String nombre;
    private  String email;
    @ElementCollection
    private Map<String, String> numTelefono;
    @Enumerated(EnumType.STRING)
    private GeneroPersona genero;

    public Persona(){
        super();
    }

    public Persona(String cedula, String nombre, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Map<String, String> numTelefono) {
        this.numTelefono = numTelefono;
    }

    public GeneroPersona getGenero() {
        return genero;
    }

    public void setGenero(GeneroPersona genero) {
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return Objects.equals(cedula, persona.cedula);
    }

    @Override
    public int hashCode() {
        return cedula != null ? cedula.hashCode() : 0;
    }
}
