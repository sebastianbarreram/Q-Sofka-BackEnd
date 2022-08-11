package co.com.qsofkau.usecase.aspirante.asignarpuntajeaspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.usecase.aspirante.consultaraspiranteporevaluacionid.ConsultarAspirantePorEvaluacionIdUseCase;
import co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo.EncontrarAspirantePorCodigoUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AsignarPuntajeAspiranteUseCase {
    private final ConsultarAspirantePorEvaluacionIdUseCase consultarAspirantePorEvaluacionIdUseCase;
    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> asignarPuntaje(String evaluacionId, Integer puntaje){
        return consultarAspirantePorEvaluacionIdUseCase.econtrarPorEvaluacionId(evaluacionId)
                .map(aspirante -> {
                    aspirante.asignarPuntaje(puntaje);
                    return aspirante;
                })
                .flatMap(aspirante -> aspiranteRepository.save(aspirante));
    }
}
