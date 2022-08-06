package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListarPreguntaConIdUseCase {

    private final PreguntaRepository preguntaRepository;

    public Mono<Pregunta> listarPreguntaConId(String id){
        return preguntaRepository.findById(id);
    }
}
