package co.com.qsofkau.model.aspirante.gateways;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.usuario.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AspiranteRepository {
    Mono<Aspirante> save(Aspirante aspirante);
    Mono<Aspirante> findById(String id);
    Flux<Aspirante> findAll();
}
