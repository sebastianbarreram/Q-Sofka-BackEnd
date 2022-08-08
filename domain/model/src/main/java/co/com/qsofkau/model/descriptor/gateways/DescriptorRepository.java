package co.com.qsofkau.model.descriptor.gateways;

import co.com.qsofkau.model.descriptor.Descriptor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DescriptorRepository {
    Mono<Descriptor> save(Descriptor descriptor);
    Flux<Descriptor> findAll();
}
