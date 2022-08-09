package co.com.qsofkau.usecase.usuario.encontrarusuarioporid;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
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
class EncontrarUsuarioPorIdUseCaseTest {

    @InjectMocks
    EncontrarUsuarioPorIdUseCase useCase;

    @Mock
    UsuarioRepository repository;

    @Test
    public void encontrar_usuario_por_id_test(){

        Usuario usuario = new Usuario("U1", "nombre usuario", "apellido usuario", "usuario@gmail.com", "rol", "user", "password");

        when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(usuario));

        StepVerifier.create(useCase.encontrarUsuarioPorId("U1"))
                .expectNext(usuario)
                .expectComplete()
                .verify();
    }

}