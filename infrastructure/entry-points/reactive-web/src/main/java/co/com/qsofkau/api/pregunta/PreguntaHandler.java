package co.com.qsofkau.api.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.usecase.pregunta.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PreguntaHandler {

    private final GuardarPreguntaUseCase guardarPreguntaUseCase;

    private final ListarPreguntasUseCase listarPreguntasUseCase;

    private final ListarPreguntaConIdUseCase listarPreguntaConIdUseCase;

    private final ActualizarPreguntaUseCase actualizarPreguntaUseCase;
    private final EliminarPreguntaUseCase eliminarPreguntaUseCase;

    private final ListarPreguntaPorCoachIdUseCase listarPreguntaPorCoachIdUseCase;

    public Mono<ServerResponse> POSTGuardarPreguntaUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Pregunta.class)
                .flatMap(pregunta -> guardarPreguntaUseCase.guardarPregunta(pregunta))
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> GETListarPreguntasUseCase(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(listarPreguntasUseCase.listarPreguntas(), Pregunta.class);
    }

    public Mono<ServerResponse> GETListarPreguntaConIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(listarPreguntaConIdUseCase.listarPreguntaConId(id), Pregunta.class);
    }

    public Mono<ServerResponse> PUTActualizarPreguntaUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Pregunta.class)
                .flatMap(pregunta -> actualizarPreguntaUseCase.actualizarPregunta(id,pregunta))
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> listenDELETEPreguntaUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarPreguntaUseCase.eliminarPregunta(id), Pregunta.class);
    }

    public Mono<ServerResponse>  GETListarPreguntaPorCoachId(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(listarPreguntaPorCoachIdUseCase.listarPorCoachId(id), Pregunta.class);
    }
}
