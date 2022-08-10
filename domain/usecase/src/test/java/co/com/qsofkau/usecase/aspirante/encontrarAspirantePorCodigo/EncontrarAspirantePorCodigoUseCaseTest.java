package co.com.qsofkau.usecase.aspirante.encontrarAspirantePorCodigo;

import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.usecase.aspirante.generarCodigo.GenerarCodigoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EncontrarAspirantePorCodigoUseCaseTest {
    @InjectMocks

    EncontrarAspirantePorCodigoUseCase useCase;

    @Mock
    AspiranteRepository repository;

    @Test
    void encontrarAspirantePorCodigo() {

    }
}