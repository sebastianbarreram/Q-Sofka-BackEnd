package co.com.qsofkau.api.pregunta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PreguntaRouterRest {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionPregunta(PreguntaHandler preguntaHandler){
        return route(POST("api/pregunta/guardar"), preguntaHandler::POSTGuardarPreguntaUseCase)
                .and(route(GET("api/pregunta/listar"), preguntaHandler::GETListarPreguntasUseCase))
                .and(route(GET("api/pregunta/listar/{id}"), preguntaHandler::GETListarPreguntaConIdUseCase))
                .and(route(PUT("api/pregunta/actualizar/{id}"), preguntaHandler::PUTActualizarPreguntaUseCase))
                .and(route(GET("api/pregunta/coach/{id}"), preguntaHandler::GETListarPreguntaPorCoachId));

    }
}
