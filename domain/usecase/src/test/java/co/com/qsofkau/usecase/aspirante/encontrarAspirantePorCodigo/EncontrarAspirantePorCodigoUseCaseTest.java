package co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.usecase.aspirante.generarCodigo.GenerarCodigoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EncontrarAspirantePorCodigoUseCaseTest {
    @InjectMocks

    EncontrarAspirantePorCodigoUseCase useCase;

    @Mock
    AspiranteRepository repository;

    @Test
    void encontrarAspirantePorCodigo() {
        Aspirante aspirante = new Aspirante("1","juan","duvanleal65@gmail.com",1,0,0,"555-hhh","555-hhh");
        Aspirante aspirante1 = new Aspirante("2","duvan","duvanleal96@gmail.com",1,0,0,"552-xxx","552-xxx");
        List<Aspirante> aspirantes = List.of(aspirante, aspirante1);

        when(repository.findAll()).thenReturn(Flux.fromIterable(aspirantes));

        StepVerifier.create(useCase.encontrarAspirantePorCodigo(aspirante1.getCodigoVerificacion()))
                .expectNext(aspirante1)
                .expectComplete()
                .verify();
    }
}