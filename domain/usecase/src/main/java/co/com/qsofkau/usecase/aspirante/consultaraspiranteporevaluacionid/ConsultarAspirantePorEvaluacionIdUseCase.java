package co.com.qsofkau.usecase.aspirante.consultaraspiranteporevaluacionid;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.io.ObjectStreamClass;
import java.util.Objects;

@RequiredArgsConstructor
public class ConsultarAspirantePorEvaluacionIdUseCase {

    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> econtrarPorEvaluacionId(String evaluacionId){
        return aspiranteRepository.findAll()
                .filter(aspirante -> Objects.nonNull(aspirante.getEvaluacionId()))
                .filter(aspirante -> aspirante.getEvaluacionId().equals(evaluacionId)).next();
    }

}
