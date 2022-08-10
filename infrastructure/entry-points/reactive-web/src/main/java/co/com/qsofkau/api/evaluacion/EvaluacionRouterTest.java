package co.com.qsofkau.api.evaluacion;

import co.com.qsofkau.api.usuario.HandlerUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EvaluacionRouterTest {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionEvaluacion(EvaluacionHandler handler) {
        return route(GET("/api/evaluacion/{id}"), handler::listenGETEncontrarEvaluacionPorId);
    }
}

