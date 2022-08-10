package co.com.qsofkau.usecase.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.evaluacion.gateways.EvaluacionRepository;
import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaEvaluacionPorIdUseCaseTest {

    @Mock
    EvaluacionRepository repository;
    @InjectMocks
    ConsultaEvaluacionPorIdUseCase useCase;

    @Test
    public void consulta_porId_exitosa(){
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

        Evaluacion evaluacionMock = new Evaluacion(preguntas);
        evaluacionMock.setId("e1");

        when(repository.findById("e1")).thenReturn(Mono.just(evaluacionMock));

        //act and assert
        StepVerifier.create(useCase.consultarPorId("e1"))
                .expectNextMatches(e -> e.getId().equals("e1"))
                .expectComplete()
                .verify();

    }

    @Test
    public void consulta_porId_longitud_array_15(){
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

        Evaluacion evaluacionMock = new Evaluacion(preguntas);
        evaluacionMock.setId("e1");

        when(repository.findById("e1")).thenReturn(Mono.just(evaluacionMock));

        System.out.println("Logintud array 1:"+evaluacionMock.getPreguntaList1().size());
        System.out.println("Logintud array 2:"+evaluacionMock.getPreguntaList2().size());
        //act and assert
        StepVerifier.create(useCase.consultarPorId("e1"))
                .expectNextMatches(e -> e.getPreguntaList1().size()==15 && e.getPreguntaList2().size()==15 )
                .expectComplete()
                .verify();

    }
}