package lesson208.repositories;

import lesson208.models.Emploee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmploeesRepositories extends CrudRepository<Emploee, String> {
    @Query("select * from Emploee limit 1")
    Optional<Emploee> loadFirtRow();

    @Query("select * from Emploee")
    List<Emploee> loadAllEmploee();

}
