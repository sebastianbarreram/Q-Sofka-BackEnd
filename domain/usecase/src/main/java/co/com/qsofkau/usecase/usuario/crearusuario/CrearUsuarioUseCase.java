package co.com.qsofkau.usecase.crearusuario;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    public Mono<Usuario> crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
