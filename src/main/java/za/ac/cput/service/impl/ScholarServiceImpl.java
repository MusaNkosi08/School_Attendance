package za.ac.cput.service.impl;

import za.ac.cput.domain.Scholar;
import za.ac.cput.repository.IScholarRepository;
import za.ac.cput.service.IScholarService;

import java.util.Set;
import java.util.stream.Collectors;

public class ScholarServiceImpl implements IScholarService {
    private static IScholarService service = null;
    private final IScholarRepository repository;

    private ScholarServiceImpl(IScholarRepository repository) {
        this.repository = repository;
    }

    public static IScholarService getService(IScholarRepository repository) {
        if (service == null) {
            service = new ScholarServiceImpl(repository);
        }
        return service;
    }

    @Override
    public Scholar create(Scholar scholar) {
        return repository.create(scholar);
    }

    @Override
    public Scholar read(String s) {
        return repository.read(s);
    }

    @Override
    public Scholar update(Scholar scholar) {
        return repository.update(scholar);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }

    @Override
    public Set<Scholar> getAll() {
        return repository.getAll();
    }

    @Override
    public Set<Scholar> getAllByGrade(String grade) {
        return repository.getAll()
                .stream()
                .filter(scholar -> scholar.getGrade().equals(grade))
                .collect(Collectors.toSet());
    }
}
