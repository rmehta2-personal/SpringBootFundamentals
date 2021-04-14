package ttl.larku.dao.interfaces;

import ttl.larku.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAOInterface
{
    void update(Student updateObject);

    void delete(Student student);

    Student create(Student newObject);

    Student get(int id);

    List<Student> getAll();

    void deleteStore();

    void createStore();

    Map<Integer, Student> getStudents();
}
