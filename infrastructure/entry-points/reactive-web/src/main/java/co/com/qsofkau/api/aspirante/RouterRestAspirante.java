package co.com.qsofkau.api.aspirante;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestAspirante {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionAspirante(HandlerAspirante handler) {
        return route(GET("/api/aspirante/{id}"), handler::listenGETEncontrarAspirantePorId)
                .andRoute(POST("/api/aspirante"), handler::listenPOSTCrearAspiranteUseCase)
                .andRoute(GET("/api/aspirante/codigo/{id}"), handler::listenGETGenerarCodigo)
                .andRoute(GET("/api/aspirante/comenzar/{codigo}"), handler::listenGETEncontrarAspirantePorNombre);
    }
}
