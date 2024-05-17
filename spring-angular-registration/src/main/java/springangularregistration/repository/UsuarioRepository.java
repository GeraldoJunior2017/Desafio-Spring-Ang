package springangularregistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springangularregistration.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}