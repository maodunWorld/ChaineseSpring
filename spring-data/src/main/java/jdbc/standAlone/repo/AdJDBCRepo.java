package jdbc.standAlone.repo;

import jdbc.standAlone.ad_stat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface AdJDBCRepo extends CrudRepository<ad_stat, Integer> {

    @Query("select * from ad_stat where adid = :integer")
    @Override
    Optional<ad_stat> findById(Integer integer);
}
