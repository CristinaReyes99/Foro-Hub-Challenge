package alura.cursos.foro_hub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity (name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private LocalDateTime fechaDeCreacion;
    private Boolean estado;


    public Topico(DatosRegistroTopico datosTopico){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
        this.estado = true;
        this.fechaDeCreacion = LocalDateTime.now();
    }


}
