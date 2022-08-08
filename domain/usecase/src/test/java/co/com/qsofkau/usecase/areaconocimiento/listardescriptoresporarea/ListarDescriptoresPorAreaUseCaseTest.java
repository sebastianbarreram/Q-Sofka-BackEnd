package co.com.qsofkau.usecase.areaconocimiento.listardescriptoresporarea;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.Descriptor;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarDescriptoresPorAreaUseCaseTest {

    @InjectMocks
    ListarDescriptoresPorAreaUseCase useCase;

    @Mock
    AreaConocimientoRepository repository;

    @Test
    public void listar_descriptores_por_area_test(){

        Descriptor descriptor1 = new Descriptor("descriptorId1", "descriptor1");
        Descriptor descriptor2 = new Descriptor("descriptorId2", "descriptor2");

        AreaConocimiento areaConocimiento = new AreaConocimiento("1", "Area conocimiento 1", List.of(descriptor1,descriptor2));

        when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(areaConocimiento));

        StepVerifier.create(useCase.listarDescriptoresAreaConocimiento("1"))
                .expectNextMatches(descriptor -> descriptor.getNombre().equals("descriptor1"))
                .expectNextMatches(descriptor -> descriptor.getNombre().equals("descriptor2"))
                .expectComplete()
                .verify();
    }
}