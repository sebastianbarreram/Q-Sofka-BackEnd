package co.com.qsofkau.api.usuario;

import co.com.qsofkau.model.usuario.Usuario;

import co.com.qsofkau.usecase.usuario.crearusuario.CrearUsuarioUseCase;
import co.com.qsofkau.usecase.usuario.encontrarusuarioporid.EncontrarUsuarioPorIdUseCase;
import co.com.qsofkau.usecase.usuario.recuperarcontrasena.RecuperarContrasenaUseCase;
import co.com.qsofkau.usecase.usuario.encontrarusuariopornombreusuario.EncontrarUsuarioPorNombreUsuarioUseCase;

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

    private final EncontrarUsuarioPorNombreUsuarioUseCase encontrarUsuarioPorNombreUsuarioUseCase;

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
        var usuarioId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(recuperarContrasenaUseCase.recuperarContrasena(usuarioId),Usuario.class);
    }


    public Mono<ServerResponse> listenGETEncontrarUsuarioPorNombreUsuario(ServerRequest serverRequest){
        var nombreUsuario=serverRequest.pathVariable("nombreusuario");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(encontrarUsuarioPorNombreUsuarioUseCase.encontrarUsuarioPorNombre(nombreUsuario),Usuario.class);
    }

}
