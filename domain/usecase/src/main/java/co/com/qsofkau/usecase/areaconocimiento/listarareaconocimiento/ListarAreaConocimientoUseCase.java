package co.com.qsofkau.usecase.areaconocimiento.listarareaconocimiento;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarAreaConocimientoUseCase {
    private final AreaConocimientoRepository areaConocimientoRepository;

    public Flux<AreaConocimiento> listarAreaConocmiento() {
        return areaConocimientoRepository.findAll();
    }
}
