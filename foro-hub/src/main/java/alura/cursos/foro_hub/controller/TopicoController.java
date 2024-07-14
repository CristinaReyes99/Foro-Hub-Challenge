package alura.cursos.foro_hub.controller;

import alura.cursos.foro_hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {

        Topico topico = repository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        Page<Topico> topicosPage = repository.findAll(paginacion);
        Page<DatosListadoTopico> datosListadoPage = topicosPage.map(DatosListadoTopico::new);
        return ResponseEntity.ok(datosListadoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> detalleTopico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        var detallesTopico = new DatosListadoTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso(),
                topico.getEstado(), topico.getFechaDeCreacion());
        return ResponseEntity.ok(detallesTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id,
                                           @RequestBody @Valid DatosActualizaTopico datosActualizaTopico) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.actualizaTopico(datosActualizaTopico);
            repository.save(topico);

            DatosListadoTopico datosListadoTopico = new DatosListadoTopico(
                    topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getAutor(), topico.getCurso(),
                    topico.getEstado(), topico.getFechaDeCreacion());
            return ResponseEntity.ok(datosListadoTopico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
