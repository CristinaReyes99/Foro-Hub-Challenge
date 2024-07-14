package alura.cursos.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizaTopico
        (String titulo,
        String mensaje,
        String autor,
        String curso){

}
