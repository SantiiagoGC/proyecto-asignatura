package co.edu.uniquindio.proyecto;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class test {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void regitrarTest(){
        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);

        Map<String, String> telefono = new HashMap<>();
        telefono.put("Casa", "323432");
        telefono.put("Celular", "123");
        Usuario usuario = new Usuario("123", "pepito", LocalDate.now(), GeneroPersona.MASCULINO,
                "pepito@gmail.com", telefono, ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        System.out.println(usuarioGuardado);
        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminarTest(){
        usuarioRepo.deleteById("123");

        Usuario usuarioConsultado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(usuarioConsultado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizarTest(){
        Usuario guardado = usuarioRepo.findById("124").orElse(null);

        guardado.setEmail("maria_correoNuevo@gmail.com");
        usuarioRepo.save(guardado);

        Usuario usuarioBuscado = usuarioRepo.findById("124").orElse(null);
        Assertions.assertEquals("maria_correoNuevo@gmail.com", usuarioBuscado.getEmail());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest(){
        List<Usuario> usuarios = usuarioRepo.findAll();

        usuarios.forEach(u -> System.out.println(u));
    }
}
