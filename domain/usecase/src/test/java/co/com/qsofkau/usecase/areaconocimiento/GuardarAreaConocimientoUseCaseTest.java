package co.com.qsofkau.usecase.areaconocimiento;

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
class GuardarAreaConocimientoUseCaseTest {

    @InjectMocks
    GuardarAreaConocimientoUseCase useCase;

    @Mock
    AreaConocimientoRepository repository;

    @Test
    public void guardar_area_de_conocimiento_test(){

        Descriptor descriptor = new Descriptor("descriptorId", "descriptor");
        AreaConocimiento areaConocimiento = new AreaConocimiento("1", "Area conocimiento 1", List.of(descriptor));

        when(repository.save(Mockito.any(AreaConocimiento.class))).thenReturn(Mono.just(areaConocimiento));

        StepVerifier.create(useCase.guardarAreaConocimiento(areaConocimiento))
                .expectNextMatches(area -> area.getNombreAreaConocimiento().equals("Area conocimiento 1"))
                .expectComplete()
                .verify();
    }
}