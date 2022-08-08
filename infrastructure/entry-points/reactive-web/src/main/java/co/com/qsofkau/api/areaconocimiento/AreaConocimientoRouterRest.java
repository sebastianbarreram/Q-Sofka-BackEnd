package co.com.qsofkau.api.areaconocimiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class AreaConocimientoRouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(AreaConocimientoHandler areaConocimientoHandler) {
        return route(POST("api/area/conocimiento/guardar"), areaConocimientoHandler::POSTGuardarAreaConocimientoUseCase)
                .and(route(GET("api/area/conocimiento/listar"), areaConocimientoHandler::GETListarAreasConocimientoUseCase))
                .and(route(GET("api/area/conocimiento/descriptores/listar/{id}"), areaConocimientoHandler::GETListarAreasConocimientoUseCase));
    }
}
