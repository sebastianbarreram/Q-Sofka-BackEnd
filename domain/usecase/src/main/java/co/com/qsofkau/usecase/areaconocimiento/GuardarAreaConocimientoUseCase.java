package co.com.qsofkau.usecase.areaconocimiento;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GuardarAreaConocimientoUseCase {

    private final AreaConocimientoRepository areaConocimientoRepository;

    public Mono<AreaConocimiento> guardarAreaConocimiento(AreaConocimiento areaConocimiento){
        return areaConocimientoRepository.save(areaConocimiento);
    }
}
