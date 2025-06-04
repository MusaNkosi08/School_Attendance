package za.ac.cput.service;

import za.ac.cput.domain.Scholar;

import java.util.Set;

public interface IScholarService extends IService<Scholar, String> {
    Set<Scholar> getAll();

    Set<Scholar> getAllByGrade(String grade);
}
