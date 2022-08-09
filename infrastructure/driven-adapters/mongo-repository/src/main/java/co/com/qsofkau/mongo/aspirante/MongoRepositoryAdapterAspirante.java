package co.com.qsofkau.mongo.aspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import co.com.qsofkau.mongo.helper.AdapterOperations;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterAspirante extends AdapterOperations<Aspirante, AspiranteDocument, String, AspiranteMongoDBRepository>
        implements AspiranteRepository
{

    public MongoRepositoryAdapterAspirante(AspiranteMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Aspirante.class));
    }

}