package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Scholar;
import za.ac.cput.factory.ScholarFactory;
import za.ac.cput.repository.IScholarRepository;
import za.ac.cput.service.impl.ScholarServiceImpl;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ScholarServiceImplTest {
    @Mock
    private IScholarRepository repository;

    @InjectMocks
    private ScholarServiceImpl service;

    private Scholar scholar;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        scholar = ScholarFactory.createScholar("8294757482928", "Musa", "Nkosi", "12", "musa@gmail.com", null);
    }

    @Test
    void testCreate() {
        when(repository.save(any(Scholar.class))).thenReturn(scholar);
        Scholar created = service.create(scholar);
        assertNotNull(created);
        assertEquals(scholar.getCemisNumber(), created.getCemisNumber());
        verify(repository, times(1)).save(any(Scholar.class));
    }

    @Test
    void testRead() {
        when(repository.findById(anyString())).thenReturn(Optional.of(scholar));
        Scholar found = service.read(scholar.getCemisNumber());
        assertNotNull(found);
        assertEquals(scholar.getCemisNumber(), found.getCemisNumber());
        verify(repository, times(1)).findById(anyString());
    }

    @Test
    void testUpdate() {
        when(repository.save(any(Scholar.class))).thenReturn(scholar);
        Scholar updated = service.update(scholar);
        assertNotNull(updated);
        assertEquals(scholar.getCemisNumber(), updated.getCemisNumber());
        verify(repository, times(1)).save(any(Scholar.class));
    }

    @Test
    void testDelete() {
        when(repository.findById(anyString())).thenReturn(Optional.of(scholar));
        boolean success = service.delete(scholar.getCemisNumber());
        assertTrue(success);
        verify(repository, times(1)).deleteById(anyString());
    }

    @Test
    void testGetAll() {
        Set<Scholar> scholars = new HashSet<>();
        scholars.add(scholar);
        when(repository.findAll()).thenReturn(scholars.stream().toList());
        Set<Scholar> found = service.getAll();
        assertNotNull(found);
        assertEquals(1, found.size());
        verify(repository, times(1)).findAll();
    }
}
