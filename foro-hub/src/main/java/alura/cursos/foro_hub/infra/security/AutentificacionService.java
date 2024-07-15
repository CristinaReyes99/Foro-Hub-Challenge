package alura.cursos.foro_hub.infra.security;

import alura.cursos.foro_hub.domain.usuario.UsuarioAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutentificacionService  implements UserDetailsService {

    @Autowired
    private UsuarioAuthRepository usuarioAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioAuthRepository.findByNombre(username);
    }
}
