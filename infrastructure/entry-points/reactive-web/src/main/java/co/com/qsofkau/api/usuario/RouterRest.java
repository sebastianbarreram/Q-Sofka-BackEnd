package co.com.qsofkau.api.usuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunctionUsuario(HandlerUsuario handler) {
    return route(GET("/api/usuario/{id}"), handler::listenGETEncontrarUsuarioPorId)
    .andRoute(POST("/api/usuario"), handler::listenPOSTCrearUsuarioUseCase);
    }
}
