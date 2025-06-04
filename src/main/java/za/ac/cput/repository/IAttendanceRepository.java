package za.ac.cput.repository;

import za.ac.cput.service.impl.AttendanceRepository;

public class IAttendanceRepository {
    private IAttendanceRepository() {
    }
    public static IAttendanceRepository getInstance() {
        return new IAttendanceRepository();
    }
}
