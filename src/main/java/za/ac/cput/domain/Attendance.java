
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate date;

    @Column(name = "attendance_time", nullable = false)
    private LocalTime time;

    protected Attendance(LocalDate date, LocalTime time) {
        // Required by JPA
    }

    private Attendance(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.time = builder.time;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private Long id;
        private LocalDate date;
        private LocalTime time;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder copy(Attendance attendance) {
            this.id = attendance.id;
            this.date = attendance.date;
            this.time = attendance.time;
            return this;
        }

        public Attendance build() {
            return new Attendance(this);
        }
    }
}