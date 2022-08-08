package co.com.qsofkau.usecase.areaconocimiento.listardescriptoresporarea;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.Descriptor;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarDescriptoresPorAreaUseCase {
    private final AreaConocimientoRepository areaConocimientoRepository;

    public Flux<Descriptor> listarDescriptoresAreaConocimiento(String idArea) {
        return areaConocimientoRepository.findById(idArea)
                .map(AreaConocimiento::getDescriptores)
                .flatMapMany(Flux::fromIterable);
    }
}
