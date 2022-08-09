package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)

public class ListarPreguntaPorCoachIdUseCaseTest {


    @InjectMocks
    ListarPreguntaPorCoachIdUseCase useCase;


    @Mock
    PreguntaRepository repository;

    @Test
    public void listar_pregunta_por_coachid_exitoso(){
        //arrange
        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);

        Pregunta pregunta = new Pregunta(
                "p1",
                "c1",
                LocalDateTime.now(),
                "pregunta",
                "area conocimiento",
                "descriptor",
                "tipo pregunta",
                opciones
        );


        when(repository.findByCoachId("c1")).thenReturn(Flux.just(pregunta));

        StepVerifier.create(useCase.listarPorCoachId(pregunta.getCoachId()))
                .expectNext(pregunta)
                .expectComplete()
                .verify();
    }

}

