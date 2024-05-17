package springangularregistration.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import springangularregistration.model.Usuario;
import springangularregistration.repository.UsuarioRepository;

import javax.validation.Valid;

@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/api/users/register")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuário inválidos");
        }


        if (usuario.getSenha() == null || usuario.getConfirmarSenha() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha ou confirmação de senha não pode ser nula");
        }


        if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha e confirmação de senha não coincidem");
        }


        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }


        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuarioSalvo);
    }
}
