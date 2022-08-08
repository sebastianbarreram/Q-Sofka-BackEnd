package co.com.qsofkau.usecase.areaconocimiento.listarareaconocimiento;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.Descriptor;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarAreaConocimientoUseCaseTest {

    @InjectMocks
    ListarAreaConocimientoUseCase useCase;

    @Mock
    AreaConocimientoRepository repository;

    @Test
    public void listar_area_de_conocmiento_test(){

        Descriptor descriptor1 = new Descriptor("descriptorId", "descriptor");
        AreaConocimiento areaConocimiento1 = new AreaConocimiento("1", "Area conocimiento 1", List.of(descriptor1));
        Descriptor descriptor2 = new Descriptor("descriptorId", "descriptor");
        AreaConocimiento areaConocimiento2 = new AreaConocimiento("2", "Area conocimiento 2", List.of(descriptor2));

        when(repository.findAll()).thenReturn(Flux.fromIterable(List.of(areaConocimiento1, areaConocimiento2)));

        StepVerifier.create(useCase.listarAreaConocmiento())
                .expectNext(areaConocimiento1)
                .expectNext(areaConocimiento2)
                .expectComplete()
                .verify();
    }
}