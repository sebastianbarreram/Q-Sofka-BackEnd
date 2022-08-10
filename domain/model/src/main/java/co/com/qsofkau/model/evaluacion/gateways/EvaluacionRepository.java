package co.com.qsofkau.model.evaluacion.gateways;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import reactor.core.publisher.Mono;

public interface EvaluacionRepository {

    Mono<Evaluacion> findById(String id);
    Mono<Evaluacion> save(Evaluacion evaluacion);

}
