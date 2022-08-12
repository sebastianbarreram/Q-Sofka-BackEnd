package co.com.qsofkau.usecase.aspirante.enviarcorreoaspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.Mensaje;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.model.usuario.Usuario;
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
class EnviarCorreoAspiranteUseCaseTest {

    @InjectMocks
    EnviarCorreoAspiranteUseCase useCase;

    @Mock
    AspiranteRepository repository;
    @Test
    void enviarCorreoTest() {
        Aspirante aspirante = new Aspirante("1","juan","duvanleal65@gmail.com",1,0,0,"555-hhh","555-hhh");
        Mensaje mensaje = new Mensaje("duvan",75,"paso la prueba");


        when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(aspirante));
        when(repository.save(Mockito.any(Aspirante.class))).thenReturn(Mono.just(aspirante));


        StepVerifier.create(useCase.enviarCorreo(aspirante.getId(),mensaje))
                .expectNext(aspirante)
                .expectComplete()
                .verify();

    }
}