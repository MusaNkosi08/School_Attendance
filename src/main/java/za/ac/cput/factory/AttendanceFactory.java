
package za.ac.cput.factory;

import za.ac.cput.domain.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceFactory {
    public static Attendance createAttendance(LocalDate date, LocalTime time) {
        if (date == null || time == null) {
            throw new IllegalArgumentException("Date and time cannot be null");
        }

        // Validate that the date is not in the future
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Attendance date cannot be in the future");
        }

        // Validate that the time is not in the future if the date is today
        if (date.equals(LocalDate.now()) && time.isAfter(LocalTime.now())) {
            throw new IllegalArgumentException("Attendance time cannot be in the future");
        }

        return new Attendance(date, time);
    }
}