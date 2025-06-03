package za.ac.cput.domain;

import java.sql.Blob;
import java.util.Objects;

public class Scholar {
    private String cemisNumber;
    private String firstNames;
    private String lastName;
    private String grade;
    private String email;
    private Blob photo;

    public Scholar(String cemisNumber, String firstNames, String lastName, String grade, String email, Blob photo) {
        this.cemisNumber = cemisNumber;
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.grade = grade;
        this.email = email;
        this.photo = photo;
    }

    public String getCemisNumber() {
        return cemisNumber;
    }

    public void setCemisNumber(String cemisNumber) {
        this.cemisNumber = cemisNumber;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scholar scholar = (Scholar) o;
        return Objects.equals(cemisNumber, scholar.cemisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cemisNumber);
    }

    @Override
    public String toString() {
        return "Scholar{" +
                "cemisNumber='" + cemisNumber + '\'' +
                ", firstNames='" + firstNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + photo +
                '}';
    }
}
