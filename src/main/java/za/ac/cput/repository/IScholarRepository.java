package za.ac.cput.repository;

import za.ac.cput.domain.Scholar;

import java.util.Set;

public interface IScholarRepository {
    Scholar create(Scholar scholar);

    Scholar read(String cemisNumber);

    Scholar update(Scholar scholar);

    boolean delete(String cemisNumber);

    Set<Scholar> getAll();
}
