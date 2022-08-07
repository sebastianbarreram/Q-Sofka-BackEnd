package co.com.qsofkau.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
/*@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(POST("api/pregunta/guardar"), handler::POSTGuardarPreguntaUseCase)
            .and(route(GET("api/pregunta/listar"), handler::GETListarPreguntasUseCase))
            .and(route(GET("api/pregunta/listar/{id}"), handler::GETListarPreguntaConIdUseCase))
            .and(route(POST("api/pregunta/actualizar/{id}"), handler::POSTActualizarPreguntaUseCase));

    }*/
}
