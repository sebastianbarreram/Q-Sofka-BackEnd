package co.com.qsofkau.model.pregunta.gateways;

import co.com.qsofkau.model.pregunta.Pregunta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PreguntaRepository {
    Mono<Pregunta> save(Pregunta pregunta);

    Flux<Pregunta> findAll();

    Mono<Pregunta> findById();

}
