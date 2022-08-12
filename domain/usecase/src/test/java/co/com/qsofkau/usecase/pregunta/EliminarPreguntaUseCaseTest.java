package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class EliminarPreguntaUseCaseTest {
    @InjectMocks
    EliminarPreguntaUseCase useCase;
    @Mock
    PreguntaRepository repository;
    @Test
    void eliminarPreguntaTest() {
        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);

        Pregunta pregunta1 = new Pregunta(
                "p1",
                "c1",
                LocalDateTime.now(),
                "pregunta prueba",
                "area conocimiento",
                "descriptor",
                "tipo pregunta", opciones
        );
        Pregunta pregunta2 = new Pregunta(
                "p2",
                "c2",
                LocalDateTime.now(),
                "pregunta prueba2",
                "area conocimiento",
                "descriptor",
                "tipo pregunta", opciones
        );

        when(repository.delete(Mockito.any(String.class))).thenReturn(Mono.just(pregunta));

        StepVerifier.create(useCase.eliminarPregunta("p2"))
                .expectNext()
                .expectComplete()
                .verify();




    }
}