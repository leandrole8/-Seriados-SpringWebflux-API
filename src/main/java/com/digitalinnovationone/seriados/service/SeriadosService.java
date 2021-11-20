package com.digitalinnovationone.seriados.service;

import com.digitalinnovationone.seriados.document.Seriados;
import com.digitalinnovationone.seriados.repository.SeriadosRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeriadosService {

    private final SeriadosRepository seriadosRepository;

    public SeriadosService(SeriadosRepository seriadosRepository) {
        this.seriadosRepository = seriadosRepository;
    }

    public Flux<Seriados> findAll(){

        return Flux.fromIterable(this.seriadosRepository.findAll());
    }

    public  Mono<Seriados> findBySeriado(String id){

        return  Mono.justOrEmpty(this.seriadosRepository.findById(id));
    }

    public Mono<Seriados> save(Seriados seriados){
        return  Mono.justOrEmpty(this.seriadosRepository.save(seriados));
    }

    public Mono<Boolean> deleteByIDSeriado(String id) {
        seriadosRepository.deleteById(id);
        return Mono.just(true);

    }
}
