package co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.aspirante.Aspirante;

import java.util.Objects;

@RequiredArgsConstructor
public class EncontrarAspirantePorCodigoUseCase {

    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> encontrarAspirantePorCodigo(String codigo){
        return aspiranteRepository.findAll()
                .filter(aspirante -> Objects.nonNull(aspirante.getCodigoVerificacion()))
                .filter(aspirante -> aspirante.getCodigoVerificacion().equals(codigo)).next();
    }
}

