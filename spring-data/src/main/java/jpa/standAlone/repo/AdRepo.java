package jpa.standAlone.repo;

import jpa.standAlone.ad_stat;
import org.springframework.data.repository.CrudRepository;

public interface AdRepo extends CrudRepository<ad_stat, Integer> {
}
