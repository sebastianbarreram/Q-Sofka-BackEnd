package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ActualizarPreguntaUseCase {

    private final PreguntaRepository preguntaRepository;

    public Mono<Pregunta> actualizarPregunta(String id, Pregunta pregunta){
        pregunta.setId(id);
        pregunta.setFechaActualizacion(LocalDateTime.now());
        return preguntaRepository.save(pregunta);
    }
}
