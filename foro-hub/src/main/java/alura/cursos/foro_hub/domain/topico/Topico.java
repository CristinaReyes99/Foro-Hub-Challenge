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


    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.estado = true;
        this.fechaDeCreacion = LocalDateTime.now();
    }


    public void actualizaTopico(DatosActualizaTopico datosActualizaTopico){
        if (datosActualizaTopico.titulo() != null){
            this.titulo = datosActualizaTopico.titulo();
        }
        if (datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }
        if (datosActualizaTopico.autor() != null){
            this.autor = datosActualizaTopico.autor();
        }
        if (datosActualizaTopico.curso() != null){
            this.curso = datosActualizaTopico.curso();
        }
    }

    public void eliminarTopico(){
        this.estado = false;
    }
}
