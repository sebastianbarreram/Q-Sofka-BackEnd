package co.com.qsofkau.usecase.aspirante.generarCodigo;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GenerarCodigoUseCase {
    private String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numeros = "0123456789";
    private final AspiranteRepository aspiranteRepository;

    public Flux<Usuario> generarCodigo(String id){
        String codigo = getRandom(mayusculas, 4)
        +"-"+getRandom(numeros, 4);
        System.out.println(codigo);
        Aspirante aspirante = aspirante.findById(id).toFuture().join();
        aspirante.setCodigoVerificacion(codigo);
        return aspiranteRepository.findById(id);
    }


    private String getRandom(String key, int length) {
		String random = "";
		for (int i = 0; random.length() < length; i++) {
            char newChar=(key.charAt((int)(Math.random() * key.length())));
            if(!random.contains(String.valueOf(newChar))){
                random+=newChar;
            }
		}
		return random;
	}
}
