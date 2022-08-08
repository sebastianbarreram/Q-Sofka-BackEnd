package co.com.qsofkau.model.areaconocimiento.gateways;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import reactor.core.publisher.Mono;

public interface AreaConocimientoRepository {

    Mono<AreaConocimiento> save(AreaConocimiento areaconocimiento);
}
