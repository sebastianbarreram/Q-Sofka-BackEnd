package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import org.junit.jupiter.api.Assertions;
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
class ActualizarPreguntaUseCaseTest {

    @InjectMocks
    ActualizarPreguntaUseCase useCase;

    @Mock
    PreguntaRepository repository;

    @Test
    public void actualizar_pregunta_test(){

        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);

        Pregunta preguntaAntigua = new Pregunta(
                "p1",
                "c1",
                LocalDateTime.now(),
                "pregunta antigua",
                "area conocimiento",
                "descriptor",
                "tipo pregunta", opciones
                );

        Pregunta preguntaNueva = preguntaAntigua
                .toBuilder()
                .pregunta("pregunta nueva")
                .build();

        when(repository.save(Mockito.any(Pregunta.class))).thenReturn(Mono.just(preguntaNueva));

        StepVerifier.create(useCase.actualizarPregunta(preguntaAntigua.getId(), preguntaNueva))
                .expectNextMatches(pregunta -> pregunta.getPregunta().equals("pregunta nueva"))
                .expectComplete()
                .verify();

        /*
        Pregunta preguntaCambio = new Pregunta();
        useCase.actualizarPregunta(preguntaAntigua.getId(), preguntaNueva)
                .flatMap(p -> {
                    preguntaCambio.setPregunta(p.getPregunta());
                    return Mono.just(p);
                }).subscribe(
                        i -> Assertions.assertEquals("pregunta nueva", i.getPregunta())
                );

         */
    }

}