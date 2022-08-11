package co.com.qsofkau.usecase.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.evaluacion.gateways.EvaluacionRepository;
import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import co.com.qsofkau.usecase.pregunta.ListarPreguntasUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearEvaluacionUseCaseTest {

    @Mock
    EvaluacionRepository evaluacionRepository;

    @Mock
    ListarPreguntasUseCase listarPreguntasUseCase;

    @InjectMocks
    CrearEvaluacionUseCase useCase;

    @Test
    public void crear_evaluacion_exitosa(){
        //arrange
        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);
        List<Pregunta> preguntas = new ArrayList<>();
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

        for(int index = 0;index<30;index++){
            preguntas.add(pregunta);
        }
        Evaluacion evaluacionGuardar = new Evaluacion(preguntas);
        Evaluacion evaluacionMock = new Evaluacion(preguntas);
        evaluacionMock.setId("e1");

        when(listarPreguntasUseCase.listarPreguntas()).thenReturn(Flux.fromIterable(preguntas));
        when(evaluacionRepository.save(Mockito.any(Evaluacion.class))).thenReturn(Mono.just(evaluacionMock));

        //act y assert
        StepVerifier.create(useCase.crearEvaluacion())
                .expectNextMatches(evaluacion -> evaluacion.getId().equals("e1"))
                .expectComplete()
                .verify();
    }
}