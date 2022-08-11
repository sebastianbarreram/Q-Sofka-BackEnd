package co.com.qsofkau.api.aspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.Mensaje;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.usecase.aspirante.crearAspirante.CrearAspiranteUseCase;
import co.com.qsofkau.usecase.aspirante.encontrarApirantePorId.EncontrarAspirantePorIdUseCase;
import co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo.EncontrarAspirantePorCodigoUseCase;
import co.com.qsofkau.usecase.aspirante.enviarcorreoaspirante.EnviarCorreoAspiranteUseCase;
import co.com.qsofkau.usecase.aspirante.generarCodigo.GenerarCodigoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerAspirante {
    private final CrearAspiranteUseCase crearAspiranteUseCase;
    private final EncontrarAspirantePorIdUseCase encontrarAspirantePorIdUseCase;
    private final GenerarCodigoUseCase generarCodigoUseCase;
    private final EncontrarAspirantePorCodigoUseCase encontrarAspirantePorCodigoUseCase;

    private final EnviarCorreoAspiranteUseCase enviarCorreoAspiranteUseCase;


    public Mono<ServerResponse> listenPOSTCrearAspiranteUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Aspirante.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearAspiranteUseCase.crearAspirante(element), Aspirante.class));
    }
    public Mono<ServerResponse> listenGETEncontrarAspirantePorId(ServerRequest serverRequest){
        var aspiranteId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(encontrarAspirantePorIdUseCase.encontrarAspirantePorId(aspiranteId),Aspirante.class);
    }

    public Mono<ServerResponse> listenGETGenerarCodigo(ServerRequest serverRequest){
        var usuarioId=serverRequest.pathVariable("id");
        return  encontrarAspirantePorIdUseCase.encontrarAspirantePorId(usuarioId)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(generarCodigoUseCase.generarCodigo(element), Aspirante.class));
    }

    public Mono<ServerResponse> listenGETEncontrarAspirantePorCodigo(ServerRequest serverRequest){
        var codigo=serverRequest.pathVariable("codigo");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(encontrarAspirantePorCodigoUseCase.encontrarAspirantePorCodigo(codigo),Aspirante.class);
    }

    public Mono<ServerResponse> listenPOSTEnviarResultadoEvaluacion(ServerRequest serverRequest){
        var usuarioId=serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Mensaje.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(enviarCorreoAspiranteUseCase.enviarCorreo(usuarioId, element), Aspirante.class));
    }

}
