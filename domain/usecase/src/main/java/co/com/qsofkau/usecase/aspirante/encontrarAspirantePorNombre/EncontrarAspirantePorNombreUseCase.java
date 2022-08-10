package co.com.qsofkau.usecase.aspirante.encontrarAspirantePorNombre;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.aspirante.Aspirante;

@RequiredArgsConstructor
public class EncontrarAspirantePorNombreUseCase {

    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> encontrarAspirantePorNombre(String nombreAspirante){
        return aspiranteRepository.findAll()
                .filter(aspirante -> aspirante.getNombre().equals(nombreAspirante)).next();
    }
}

