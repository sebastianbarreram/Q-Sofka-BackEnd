package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarPreguntaUseCase {

    private final PreguntaRepository preguntaRepository;

    public Mono<Pregunta> actualizarPregunta(String id, Pregunta pregunta){
        pregunta.setId(id);
        return preguntaRepository.save(pregunta);
    }
}
