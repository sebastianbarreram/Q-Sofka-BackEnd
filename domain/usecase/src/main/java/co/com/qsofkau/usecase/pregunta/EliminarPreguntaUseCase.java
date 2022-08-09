package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarPreguntaUseCase {
    private final PreguntaRepository preguntaRepository;
    public Mono<Void> eliminarPregunta(String id) {
        return preguntaRepository.delete(id);
    }
}
