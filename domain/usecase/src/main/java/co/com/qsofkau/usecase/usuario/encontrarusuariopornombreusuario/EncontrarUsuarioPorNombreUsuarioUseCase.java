package co.com.qsofkau.usecase.usuario.encontrarusuariopornombreusuario;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EncontrarUsuarioPorNombreUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Mono<Usuario> encontrarUsuarioPorNombre(String usuario){
        return usuarioRepository.findAll()
                .filter(usuario1 -> usuario1.getUsuario().equals(usuario)).next();

    }

}
