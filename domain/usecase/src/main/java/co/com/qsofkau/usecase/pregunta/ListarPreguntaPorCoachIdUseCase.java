package co.com.qsofkau.usecase.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarPreguntaPorCoachIdUseCase {
    private final PreguntaRepository preguntaRepository;

    public Flux<Pregunta> listarPorCoachId(String id){
        return preguntaRepository.findByCoachId(id);
    }
}
