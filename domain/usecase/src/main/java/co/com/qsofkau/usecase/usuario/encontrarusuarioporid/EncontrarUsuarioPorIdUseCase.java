package co.com.qsofkau.usecase.usuario.encontrarusuarioporid;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EncontrarUsuarioPorIdUseCase {
    private final UsuarioRepository usuarioRepository;
    public Mono<Usuario> encontrarUsuarioPorId(String id) {
        System.out.println(id);
        return usuarioRepository.findById(id);
    }
}
