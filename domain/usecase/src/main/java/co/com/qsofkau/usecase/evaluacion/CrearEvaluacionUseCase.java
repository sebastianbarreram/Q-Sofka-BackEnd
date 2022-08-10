package co.com.qsofkau.usecase.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.evaluacion.gateways.EvaluacionRepository;
import co.com.qsofkau.usecase.pregunta.ListarPreguntasUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearEvaluacionUseCase {

    private final EvaluacionRepository repository;
    private final ListarPreguntasUseCase listarPreguntasUseCase;

    public Mono<Evaluacion> crearEvaluacion(){

        return listarPreguntasUseCase.listarPreguntas()
                .collectList()
                .map(lista -> new Evaluacion(lista))
                .flatMap(evaluacion -> repository.save(evaluacion));
    }
}
