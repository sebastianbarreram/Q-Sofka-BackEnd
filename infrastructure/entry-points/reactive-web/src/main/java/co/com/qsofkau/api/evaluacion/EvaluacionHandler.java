package co.com.qsofkau.api.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.usecase.evaluacion.ConsultaEvaluacionPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EvaluacionHandler {
    private final ConsultaEvaluacionPorIdUseCase consultaEvaluacionPorIdUseCase;
    public Mono<ServerResponse> listenGETEncontrarEvaluacionPorId(ServerRequest serverRequest){
        var evaluacionId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultaEvaluacionPorIdUseCase.consultarPorId(evaluacionId), Evaluacion.class);
    }
}
