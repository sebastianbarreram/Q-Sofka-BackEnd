package co.com.qsofkau.mongo.areaconocimiento.repository;

import co.com.qsofkau.model.areaconocimiento.AreaConocimiento;
import co.com.qsofkau.model.areaconocimiento.gateways.AreaConocimientoRepository;
import co.com.qsofkau.mongo.areaconocimiento.document.AreaConocimientoDocument;
import co.com.qsofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDBAreaConocimientoRepositoryAdapter extends AdapterOperations<AreaConocimiento, AreaConocimientoDocument, String, MongoDBAreaConocimientoRepository>
        implements AreaConocimientoRepository
{

    public MongoDBAreaConocimientoRepositoryAdapter(MongoDBAreaConocimientoRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d,  AreaConocimiento.class));
    }


}
