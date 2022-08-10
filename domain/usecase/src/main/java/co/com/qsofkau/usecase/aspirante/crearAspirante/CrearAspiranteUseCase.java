package co.com.qsofkau.usecase.aspirante.crearAspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.usecase.aspirante.generarCodigo.GenerarCodigoUseCase;
import co.com.qsofkau.usecase.evaluacion.CrearEvaluacionUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class CrearAspiranteUseCase {
    private final CrearEvaluacionUseCase crearEvaluacionUseCase;
    private final AspiranteRepository aspiranteRepository;
    private final GenerarCodigoUseCase generarCodigoUseCase;
    public Mono<Aspirante> crearAspirante(Aspirante aspirante) {
        return crearEvaluacionUseCase.crearEvaluacion().map(evaluacion ->
        { aspirante.setEvaluacionId(evaluacion.getId());
                return aspirante;
        }).flatMap(aspirante1-> aspiranteRepository.save(aspirante)
        ).flatMap(aspirante1 -> generarCodigoUseCase.generarCodigo(aspirante1));
    }
}
