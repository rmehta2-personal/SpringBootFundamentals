package ttl.larku.service;

import org.springframework.stereotype.Component;
import ttl.larku.dao.BaseDAO;
import ttl.larku.domain.Course;

import javax.annotation.Resource;
import java.util.List;

@Component // Tells spring to treat this class as a bean property
public class CourseService {

    /*
     * @Autowired/@Resource:
     * This is replacing the explicit setter call we had to make in case of StudentService in the LarkUConfig file.
     * With this in place the setter of this attribute is not called, but sprint auto wires the instances.
     * Ensure that at least one of the subclass of BaseDAO<Course> is annotated with @Component
     * If multiple subclasses of BaseDAO<Course> is annotated with @Component then:
     * 1. Make sure one of them is annotated with @Primary which tells spring the default type to create an instance of. OR
     * 2. use @Resource instead of @Autowired
     */
    // @Autowired // This will instantiate the attribute with default (@Primary) derived type
    @Resource(name="jpaCourseDAO")
    private BaseDAO<Course> courseDAO;

    public CourseService() {
        int i = 0;
    }

    public Course createCourse(String code, String title) {
        Course course = new Course(code, title);
        course = courseDAO.create(course);

        return course;
    }

    public Course createCourse(Course course) {
        course = courseDAO.create(course);

        return course;
    }

    public void deleteCourse(int id) {
        Course course = courseDAO.get(id);
        if (course != null) {
            courseDAO.delete(course);
        }
    }

    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public Course getCourseByCode(String code) {
        List<Course> courses = courseDAO.getAll();
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public Course getCourse(int id) {
        return courseDAO.get(id);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAll();
    }

    public BaseDAO<Course> getCourseDAO() {
        return courseDAO;
    }

    public void setCourseDAO(BaseDAO<Course> courseDAO) {
        this.courseDAO = courseDAO;
    }
}
