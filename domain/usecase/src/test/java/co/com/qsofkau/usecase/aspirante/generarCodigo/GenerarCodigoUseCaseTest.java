package co.com.qsofkau.usecase.aspirante.generarCodigo;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerarCodigoUseCaseTest {
    @InjectMocks
    GenerarCodigoUseCase useCase;

    @Mock
    AspiranteRepository repository;
    @Test
    void generarCodigo() {
        Aspirante aspirante = new Aspirante("1","juan","duvanleal65@gmail.com",1,0,0,"555-hhh","555-hhh");

        when(repository.save(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspirante));

        StepVerifier.create(useCase.generarCodigo(aspirante))
                .expectNext(aspirante)
                .expectComplete()
                .verify();
    }
}