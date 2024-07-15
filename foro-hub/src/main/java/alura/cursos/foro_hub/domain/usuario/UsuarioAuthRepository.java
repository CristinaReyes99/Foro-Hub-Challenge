package alura.cursos.foro_hub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioAuthRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String username);
}
