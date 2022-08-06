package co.com.qsofkau.mongo.usuario;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface UsuarioMongoDBRepository extends ReactiveMongoRepository<UsuarioDocument, String>, ReactiveQueryByExampleExecutor<UsuarioDocument> {
}
