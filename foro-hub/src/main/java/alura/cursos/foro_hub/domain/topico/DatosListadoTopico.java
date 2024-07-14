package alura.cursos.foro_hub.domain.topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        Boolean estado,
        java.time.LocalDateTime fechaDeCreacion) {


    public DatosListadoTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getFechaDeCreacion());
    }
}