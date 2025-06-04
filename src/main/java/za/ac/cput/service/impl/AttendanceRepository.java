package za.ac.cput.service.impl;

public class AttendanceRepository {
    private static AttendanceRepository repository = null;
    private AttendanceRepository() {
    }
    public static AttendanceRepository getInstance() {
        if (repository == null) {
            repository = new AttendanceRepository();
        }
        return repository;
    }

}
