package co.com.qsofkau.api.areaconocimiento;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.descriptor.Descriptor;
import co.com.qsofkau.usecase.areaconocimiento.GuardarAreaConocimientoUseCase;
import co.com.qsofkau.usecase.areaconocimiento.listarareaconocimiento.ListarAreaConocimientoUseCase;
import co.com.qsofkau.usecase.areaconocimiento.listardescriptoresporarea.ListarDescriptoresPorAreaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AreaConocimientoHandler {
    private final GuardarAreaConocimientoUseCase guardarAreaConocimientoUseCase;
    private final ListarAreaConocimientoUseCase listarAreaConocimientoUseCase;
    private final ListarDescriptoresPorAreaUseCase listarDescriptoresPorAreaUseCase;

    public Mono<ServerResponse> POSTGuardarAreaConocimientoUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(AreaConocimiento.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(guardarAreaConocimientoUseCase.guardarAreaConocimiento(result), AreaConocimiento.class));
    }

    public Mono<ServerResponse> GETListarAreasConocimientoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarAreaConocimientoUseCase.listarAreaConocmiento(), AreaConocimiento.class);
    }

    public Mono<ServerResponse> GETListarDescriptoresUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarDescriptoresPorAreaUseCase.listarDescriptoresAreaConocimiento(id), Descriptor.class);
    }


}
