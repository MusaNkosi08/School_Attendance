package za.ac.cput.factory;

import za.ac.cput.domain.Scholar;

import java.sql.Blob;

public class ScholarFactory {
    private ScholarFactory() {
    }

    public static Scholar createScholar(String cemisNumber, String firstNames, String lastName, String grade, String email, Blob photo) {
        if (cemisNumber == null || cemisNumber.trim().isEmpty() || !isValidCemisNumber(cemisNumber))
            throw new IllegalArgumentException("Invalid CEMIS number");
        if (firstNames == null || firstNames.trim().isEmpty())
            throw new IllegalArgumentException("First names required");
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Last name required");
        if (grade == null || grade.trim().isEmpty())
            throw new IllegalArgumentException("Grade required");
        if (email == null || email.trim().isEmpty() || !isValidEmail(email))
            throw new IllegalArgumentException("Invalid email");

        return new Scholar(cemisNumber.trim(), firstNames.trim(), lastName.trim(), grade.trim(), email.trim(), photo);
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private static boolean isValidCemisNumber(String cemisNumber) {
        return cemisNumber.matches("\\d{13}");
    }
}
