package alura.cursos.foro_hub.controller;


import alura.cursos.foro_hub.domain.usuario.DatosAutentificarUsuario;
import alura.cursos.foro_hub.domain.usuario.Usuario;
import alura.cursos.foro_hub.infra.security.DatosJWTToken;
import alura.cursos.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autentificarUsuario(@RequestBody @Valid DatosAutentificarUsuario datosAutentificarUsuario){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAutentificarUsuario.nombre(),
                datosAutentificarUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JWTToken = tokenService.generarToken((Usuario)usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }
}
