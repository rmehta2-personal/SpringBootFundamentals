package ttl.larku.dao.inmemory;

import ttl.larku.dao.interfaces.StudentDAOInterface;
import ttl.larku.domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryStudentDAO implements StudentDAOInterface
{

    private Map<Integer, Student> students = new HashMap<Integer, Student>();
    private static AtomicInteger nextId = new AtomicInteger(0);

    @Override
    public void update(Student updateObject) {
        if (students.containsKey(updateObject.getId())) {
            students.put(updateObject.getId(), updateObject);
        }
    }

    @Override
    public void delete(Student student) {
        students.remove(student.getId());
    }

    @Override
    public Student create(Student newObject) {
        //Create a new Id
        int newId = nextId.getAndIncrement();
        newObject.setId(newId);
        students.put(newId, newObject);

        return newObject;
    }

    @Override
    public Student get(int id) {
        return students.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public void deleteStore() {
        students = null;
    }

    @Override
    public void createStore() {
        students = new HashMap<Integer, Student>();
        nextId = new AtomicInteger(0);
    }

    @Override
    public Map<Integer, Student> getStudents() {
        return students;
    }
}
