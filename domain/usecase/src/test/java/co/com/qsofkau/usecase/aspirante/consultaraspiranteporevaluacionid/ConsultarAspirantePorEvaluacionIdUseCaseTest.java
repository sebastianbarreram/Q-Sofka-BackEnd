package co.com.qsofkau.usecase.aspirante.consultaraspiranteporevaluacionid;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo.EncontrarAspirantePorCodigoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultarAspirantePorEvaluacionIdUseCaseTest {
    @InjectMocks

    ConsultarAspirantePorEvaluacionIdUseCase useCase;

    @Mock
    AspiranteRepository repository;

    @Test
    void encontrarAspirantePorEvaluacion() {
        Aspirante aspirante = new Aspirante("1","a1","test@gmail.com",1,0,0,"aprobo","e1");
        Aspirante aspirante1 = new Aspirante("2","a2","test@gmail.com",1,0,0,"aprobo","e2");
        List<Aspirante> aspirantes = List.of(aspirante, aspirante1);

        when(repository.findAll()).thenReturn(Flux.fromIterable(aspirantes));

        StepVerifier.create(useCase.econtrarPorEvaluacionId("e2"))
                .expectNextMatches(a -> a.getNombre().equals("a2"))
                .expectComplete()
                .verify();
    }
}