package co.com.qsofkau.model.usuario.gateways;

import co.com.qsofkau.model.usuario.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepository {
    Mono<Usuario> save(Usuario usuario);
    Mono<Usuario> findById(String id);
    Flux<Usuario> findAll();
}
