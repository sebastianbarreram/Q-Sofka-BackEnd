package co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.aspirante.Aspirante;

@RequiredArgsConstructor
public class EncontrarAspirantePorCodigoUseCase {

    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> encontrarAspirantePorCodigo(String codigo){
        return aspiranteRepository.findAll()
                .filter(aspirante -> aspirante.getCodigoVerificacion().equals(codigo)).next();
    }
}

