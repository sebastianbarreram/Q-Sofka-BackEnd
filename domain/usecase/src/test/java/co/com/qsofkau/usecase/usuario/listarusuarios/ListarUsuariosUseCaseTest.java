package co.com.qsofkau.usecase.usuario.listarusuarios;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarUsuariosUseCaseTest {

    @InjectMocks
    ListarUsuariosUseCase useCase;

    @Mock
    UsuarioRepository repository;

    @Test
    public void listar_usuarios_test(){

        Usuario usuario1 = new Usuario("U1", "nombre usuario1", "apellido usuario1", "usuario1@gmail.com", "rol", "user1", "password");
        Usuario usuario2 = new Usuario("U2", "nombre usuario2", "apellido usuario2", "usuario2@gmail.com", "rol", "user2", "password");
        List<Usuario> usuarios = List.of(usuario1, usuario2);

        when(repository.findAll()).thenReturn(Flux.fromIterable(usuarios));

        StepVerifier.create(useCase.listarUsuarios())
                .expectNext(usuario1)
                .expectNext(usuario2)
                .expectComplete()
                .verify();
    }

}