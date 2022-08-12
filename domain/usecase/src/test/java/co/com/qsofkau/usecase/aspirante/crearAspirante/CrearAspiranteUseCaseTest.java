package co.com.qsofkau.usecase.aspirante.crearAspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.pregunta.Opcion;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import co.com.qsofkau.usecase.aspirante.generarCodigo.GenerarCodigoUseCase;
import co.com.qsofkau.usecase.evaluacion.CrearEvaluacionUseCase;
import co.com.qsofkau.usecase.usuario.crearusuario.CrearUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
class CrearAspiranteUseCaseTest {

    @InjectMocks
    CrearAspiranteUseCase useCase;
    @Mock
    CrearEvaluacionUseCase crearEvaluacion;
    @Mock
    AspiranteRepository repository;

    @Mock
    GenerarCodigoUseCase generarCodigo;
    @Test
    void crearAspirante() {
        Aspirante aspirante = new Aspirante("1","juan","duvanleal65@gmail.com",1,0,0,null,null);
        Aspirante aspiranteDespues = new Aspirante("1","juan","duvanleal65@gmail.com",1,0,0,"555-hhh",null);

        Opcion opcion1 = new Opcion("verdadero", true);
        Opcion opcion2 = new Opcion("falso", false);
        Set<Opcion> opciones = Set.of(opcion1, opcion2);
        Pregunta pregunta1 = new Pregunta(
                "p1",
                "c1",
                LocalDateTime.now(),
                "pregunta",
                "area conocimiento",
                "descriptor",
                "tipo pregunta",
                opciones
        );
        Pregunta pregunta2 = new Pregunta(
                "p2",
                "c1",
                LocalDateTime.now(),
                "pregunta2",
                "area conocimiento",
                "descriptor",
                "tipo pregunta",
                opciones
        );
        List<Pregunta> preguntas = List.of(pregunta1);
        List<Pregunta> preguntas2 = List.of(pregunta2);
        Evaluacion evaluacion = new Evaluacion("23",preguntas,preguntas2);


        when(repository.save(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspirante));
        when(crearEvaluacion.crearEvaluacion()).thenReturn(Mono.just(evaluacion));
        when(generarCodigo.generarCodigo(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspiranteDespues));


        StepVerifier.create(useCase.crearAspirante(aspirante))
                .expectNext(aspiranteDespues)
                .expectComplete()
                .verify();
    }

    @Test
    void verificarCorreoAspiranteCreado(){

        Aspirante aspirante = Aspirante.builder().id("123").correo("123@gmail.com").build();
        Evaluacion evaluacion = Evaluacion.builder().id("1234").build();
        Aspirante aspiranteDespues = Aspirante.builder().id("1234").correo("123@gmail.com").build();
                when(repository.save(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspirante));
                 when(crearEvaluacion.crearEvaluacion()).thenReturn(Mono.just(evaluacion));
                 when(generarCodigo.generarCodigo(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspiranteDespues));

                StepVerifier.create(useCase.crearAspirante(aspirante))
                        .expectNextMatches(aspiranteUno -> aspiranteUno.getCorreo().equals("123@gmail.com"))
                        .expectComplete().verify();

    }
}