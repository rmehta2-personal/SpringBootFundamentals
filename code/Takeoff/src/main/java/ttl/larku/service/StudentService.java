package ttl.larku.service;

import ttl.larku.dao.factory.StudentDAOFactory;
import ttl.larku.dao.interfaces.StudentDAOInterface;
import ttl.larku.domain.Student;
import ttl.larku.domain.Student.Status;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<String> stuff = new ArrayList<>();
    private final StudentDAOInterface studentDAO;

    public StudentService(StudentDAOInterface studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentService() {
        this.studentDAO = StudentDAOFactory.getStudentDAO();
    }

    public Student createStudent(String name, String phoneNumber, Status status) {
        Student student = new Student(name, phoneNumber, status);
        student = createStudent(student);
        return student;
    }

    public Student createStudent(Student student) {
        student = studentDAO.create(student);

        return student;
    }

    public void deleteStudent(int id) {
        Student student = studentDAO.get(id);
        if (student != null) {
            studentDAO.delete(student);
        }
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public Student getStudent(int id) {
        return studentDAO.get(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    public StudentDAOInterface getStudentDAO() {
        return studentDAO;
    }

}
