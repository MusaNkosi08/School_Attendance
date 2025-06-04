package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = "scholar")
public class Scholar {
    @Id
    @Column(name = "cemis_number", length = 13)
    @Pattern(regexp = "^[0-9]{13}$", message = "CEMIS number must be 13 digits")
    private String cemisNumber;

    @Column(name = "first_names")
    private String firstNames;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name required")
    private String lastName;

    @Column(name = "grade")
    @NotEmpty(message = "Grade required")
    private String grade;

    @Column(name = "email")
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email required")
    private String email;

    @Lob
    @Column(name = "photo")
    private Blob photo;

    public Scholar(String cemisNumber, String firstNames, String lastName, String grade, String email, Blob photo) {
        this.cemisNumber = cemisNumber;
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.grade = grade;
        this.email = email;
        this.photo = photo;
    }

    public Scholar() {

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