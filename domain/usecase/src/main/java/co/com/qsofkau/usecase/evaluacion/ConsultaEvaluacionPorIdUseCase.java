package co.com.qsofkau.usecase.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.evaluacion.gateways.EvaluacionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultaEvaluacionPorIdUseCase {
    private final EvaluacionRepository repository;

    public Mono<Evaluacion> consultarPorId(String id){
        return repository.findById(id);
    }
}
