package co.com.qsofkau.usecase.aspirante.asignarpuntajeaspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.usecase.aspirante.consultaraspiranteporevaluacionid.ConsultarAspirantePorEvaluacionIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarPuntajeAspiranteUseCaseTest {

    @Mock
    AspiranteRepository repository;

    @Mock
    ConsultarAspirantePorEvaluacionIdUseCase consultarUseCase;

    @InjectMocks
    AsignarPuntajeAspiranteUseCase useCase;

    @Test
    public void asignar_primer_puntaje(){
        Integer puntaje = 10;
        Aspirante aspirante = new Aspirante("1","a1","test@gmail.com",1,0,0,"aprobo","e1");

        when(repository.save(Mockito.any(Aspirante.class))).thenAnswer(item -> item.getArguments()[0]);
        when(consultarUseCase.econtrarPorEvaluacionId("e1")).thenReturn(Mono.just(aspirante));

        StepVerifier.create(useCase.asignarPuntaje("e1",puntaje))
                .expectNextMatches(aspirante1 -> aspirante1.getPuntajePrueba1()==puntaje && aspirante1.getPuntajePrueba1()==0)
                .expectComplete()
                .verify();

    }

}