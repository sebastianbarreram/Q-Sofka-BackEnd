package co.com.qsofkau.usecase.pregunta;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GuardarPreguntaUseCase {

    private final PreguntaRepository preguntaRepository;

    public Mono<Pregunta> guardarPregunta(Pregunta pregunta){
        pregunta.setFechaCreacion(LocalDateTime.now());
        pregunta.setFechaActualizacion(LocalDateTime.now());
        return preguntaRepository.save(pregunta);
    }

}
