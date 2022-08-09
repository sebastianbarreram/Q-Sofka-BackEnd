package co.com.qsofkau.usecase.aspirante.encontrarApirantePorId;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EncontrarAspirantePorIdUseCase {
    private final AspiranteRepository aspiranteRepository;
    public Mono<Aspirante> encontrarAspirantePorId(String id) {
        System.out.println(id);
        return aspiranteRepository.findById(id);
    }
}
