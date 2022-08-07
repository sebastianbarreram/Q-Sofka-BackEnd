package co.com.qsofkau.usecase.listarusuarios;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarUsuariosUseCase {
    private final UsuarioRepository usuarioRepository;

    public Flux<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
