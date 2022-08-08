package co.com.qsofkau.model.areaconocimiento.gateways;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AreaConocimientoRepository {

    Mono<AreaConocimiento> save(AreaConocimiento areaconocimiento);
    Flux<AreaConocimiento> findAll();
    Mono<AreaConocimiento> findById(String id);
}
