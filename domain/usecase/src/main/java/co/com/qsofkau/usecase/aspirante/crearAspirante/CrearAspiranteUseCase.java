package co.com.qsofkau.usecase.aspirante.crearAspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearAspiranteUseCase {
    private final AspiranteRepository aspiranteRepository;
    public Mono<Aspirante> crearAspirante(Aspirante aspirante) {
        return aspiranteRepository.save(aspirante);
    }
}
