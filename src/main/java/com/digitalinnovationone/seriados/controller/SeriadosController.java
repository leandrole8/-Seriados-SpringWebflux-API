package com.digitalinnovationone.seriados.controller;

import com.digitalinnovationone.seriados.document.Seriados;
import com.digitalinnovationone.seriados.repository.SeriadosRepository;
import com.digitalinnovationone.seriados.service.SeriadosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovationone.seriados.constants.SeriadosConstant.SERIADOS_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class SeriadosController {

    SeriadosService seriadosService;

    SeriadosRepository seriadosRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(SeriadosController.class);

    public SeriadosController(SeriadosService seriadosService, SeriadosRepository seriadosRepository) {
        this.seriadosService = seriadosService;
        this.seriadosRepository = seriadosRepository;
    }

    @GetMapping(SERIADOS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Seriados> getAllItems() {
        log.info("requesting the list off all heroes");
        return seriadosService.findAll();

    }

    @GetMapping(SERIADOS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Seriados>> findBySeriado(@PathVariable String id) {
        log.info("Requesting the seriado with id {}", id);
        return seriadosService.findBySeriado(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(SERIADOS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Seriados> createSeriado(@RequestBody Seriados seriados) {
        log.info("A new Seriado was Created");
        return seriadosService.save(seriados);

    }

    @DeleteMapping(SERIADOS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteBySeriado(@PathVariable String id) {
        seriadosService.deleteByIDSeriado(id);
        log.info("Deleting the seriado with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
