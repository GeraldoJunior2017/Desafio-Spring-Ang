package springangularregistration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import springangularregistration.model.Usuario;
import springangularregistration.repository.UsuarioRepository;
import springangularregistration.service.UsuarioService;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // Evita a substituição do DataSource
public class UsuarioServiceTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testSalvarUsuario() {
        // Arrange
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        Usuario usuario = new Usuario("Geraldo", "geraldo@gmail.com", "senha123");

        // Act
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);

        // Assert
        assertNotNull(usuarioSalvo.getId()); // Garante que o usuário tenha sido salvo com sucesso
    }


    @Test
    public void testEmailJaCadastrado() {
        // Arrange
        String email = "geraldo@gmail.com";

        // Act
        boolean resultado = usuarioRepository.existsByEmail(email);

        // Assert
        assertTrue(resultado);
        System.out.println("O email " + email + " está cadastrado no banco de dados.");
    }


}
