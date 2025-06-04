package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Objects;

public class Attendance {
    private LocalDate date;
    private LocalTime time;

    public Attendance() {
    }

    public Attendance(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    private Attendance(Builder builder){
        this.date= builder.date;
        this.time= builder.time;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "date=" + date +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private LocalDate date;
        private LocalTime time;

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder copy(Attendance attendance) {
            this.date = attendance.date;
            this.time = attendance.time;
            return this;
        }

        public Attendance build() {
            return new Attendance(this);
        }
    }
}
