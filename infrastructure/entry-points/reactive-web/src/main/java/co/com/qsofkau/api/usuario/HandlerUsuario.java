package co.com.qsofkau.api.usuario;

import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.usecase.crearusuario.CrearUsuarioUseCase;
import co.com.qsofkau.usecase.encontrarusuarioporid.EncontrarUsuarioPorIdUseCase;
import co.com.qsofkau.usecase.recuperarcontrasena.RecuperarContrasenaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerUsuario {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final EncontrarUsuarioPorIdUseCase encontrarUsuarioPorIdUseCase;
    private final RecuperarContrasenaUseCase recuperarContrasenaUseCase;

    public Mono<ServerResponse> listenPOSTCrearUsuarioUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Usuario.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearUsuarioUseCase.crearUsuario(element), Usuario.class));
    }
    public Mono<ServerResponse> listenGETEncontrarUsuarioPorId(ServerRequest serverRequest){
        var usuarioId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(encontrarUsuarioPorIdUseCase.encontrarUsuarioPorId(usuarioId),Usuario.class);
    }

    public Mono<ServerResponse> listenGETRecuperarContrasena(ServerRequest serverRequest){
        //var usuarioId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(recuperarContrasenaUseCase.recuperarContrasena(),Usuario.class);
    }

}
