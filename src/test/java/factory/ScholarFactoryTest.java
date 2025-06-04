package factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Scholar;
import za.ac.cput.factory.ScholarFactory;

import java.sql.Blob;

import static org.junit.jupiter.api.Assertions.*;

public class ScholarFactoryTest {
    private String validCemisNumber;
    private String validFirstNames;
    private String validLastName;
    private String validGrade;
    private String validEmail;
    private Blob photo;

    @BeforeEach
    void setUp() {
        validCemisNumber = "8294757482928";
        validFirstNames = "Musa";
        validLastName = "Nkosi";
        validGrade = "12";
        validEmail = "musa@gmail.com";
        photo = null;
    }

    @Test
    void testCreateValidScholar() {
        Scholar scholar = ScholarFactory.createScholar(
                validCemisNumber,
                validFirstNames,
                validLastName,
                validGrade,
                validEmail,
                photo
        );
        assertNotNull(scholar);
        assertEquals(validCemisNumber, scholar.getCemisNumber());
        assertEquals(validFirstNames, scholar.getFirstNames());
        assertEquals(validLastName, scholar.getLastName());
        assertEquals(validGrade, scholar.getGrade());
        assertEquals(validEmail, scholar.getEmail());
    }

    @Test
    void testInvalidCemisNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                ScholarFactory.createScholar(
                        "123",
                        validFirstNames,
                        validLastName,
                        validGrade,
                        validEmail,
                        photo
                )
        );
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                ScholarFactory.createScholar(
                        validCemisNumber,
                        validFirstNames,
                        validLastName,
                        validGrade,
                        "invalid-email",
                        photo
                )
        );
    }

    @Test
    void testNullFirstNames() {
        assertThrows(IllegalArgumentException.class, () ->
                ScholarFactory.createScholar(
                        validCemisNumber,
                        null,
                        validLastName,
                        validGrade,
                        validEmail,
                        photo
                )
        );
    }
}
