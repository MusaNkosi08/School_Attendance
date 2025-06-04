package za.ac.cput.service;

import za.ac.cput.domain.Scholar;

import java.util.Optional;
import java.util.Set;

public interface IScholarService extends IService<Scholar, String> {
    Set<Scholar> getAll();

    Set<Scholar> getAllByGrade(String grade);

    Optional<Scholar> findByEmail(String email);

    Set<Scholar> findByLastName(String lastName);

    Optional<Scholar> findByCemisNumber(String cemisNumber);
}
