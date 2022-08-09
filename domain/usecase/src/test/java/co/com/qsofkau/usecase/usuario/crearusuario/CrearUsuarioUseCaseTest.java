package co.com.qsofkau.usecase.usuario.crearusuario;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import co.com.qsofkau.usecase.usuario.crearusuario.CrearUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearUsuarioUseCaseTest {

    @InjectMocks
    CrearUsuarioUseCase useCase;

    @Mock
    UsuarioRepository repository;

    @Test
    public void crear_usuario_test() {

        Usuario usuario = new Usuario("U1", "nombre usuario", "apellido usuario", "usuario@gmail.com", "rol", "user", "password");

        when(repository.save(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        StepVerifier.create(useCase.crearUsuario(usuario))
                .expectNext(usuario)
                .expectComplete()
                .verify();

    }

}