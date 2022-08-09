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
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarPreguntasUseCaseTest {

    @InjectMocks
    ListarPreguntasUseCase useCase;

    @Mock
    PreguntaRepository repository;

    @Test
    public void listar_preguntas_test(){

        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);

        Pregunta pregunta1 = new Pregunta(
                "p1",
                "c1",
                LocalDateTime.now(),
                LocalDateTime.now(),
                "pregunta1",
                "area conocimiento",
                "descriptor",
                "tipo pregunta",
                opciones
        );

        Pregunta pregunta2 = new Pregunta(
                "p2",
                "c2",
                LocalDateTime.now(),
                LocalDateTime.now(),
                "pregunta2",
                "area conocimiento",
                "descriptor",
                "tipo pregunta",
                opciones
        );

        when(repository.findAll()).thenReturn(Flux.fromIterable(List.of(pregunta1,pregunta2)));

        StepVerifier.create(useCase.listarPreguntas())
                .expectNext(pregunta1)
                .expectNext(pregunta2)
                .expectComplete()
                .verify();
    }

}