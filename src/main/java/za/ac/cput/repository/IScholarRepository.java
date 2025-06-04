package za.ac.cput.repository;

import za.ac.cput.domain.Scholar;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IScholarRepository {
    Scholar create(Scholar scholar);

    Scholar read(String cemisNumber);

    Scholar update(Scholar scholar);

    boolean delete(String cemisNumber);

    Set<Scholar> getAll();

    List<Scholar> findAll();

    Optional<Scholar> findById(String cemisNumber);

    void deleteById(String cemisNumber);

    Scholar save(Scholar scholar);
}
