package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String cedula;
    private String nombre;
    private  String email;
    @ElementCollection
    private Map<String, String> numTelefono;
    @Enumerated(EnumType.STRING)
    private GeneroPersona genero;

    public Persona(String cedula, String nombre, String email, Map<String, String> numTelefono, GeneroPersona genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.numTelefono = numTelefono;
        this.genero = genero;
    }
}
