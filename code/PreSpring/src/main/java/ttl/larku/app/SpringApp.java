package ttl.larku.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttl.larku.dao.MyFactory;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

import java.util.List;

public class SpringApp {

    int value;

    static Logger logger = LoggerFactory.getLogger(RegistrationApp.class);

    public static void main(String[] args) {
        //primeAndPrintBoth();
        SpringApp sapp = new SpringApp();
        //sapp.postRequestToAddAStudent();
        //sapp.getRequestForAllStudents();
        sapp.getRequestForAllCourses();

        System.out.println("Done!!");
    }


    public void postRequestToAddAStudent() {
        logger.info("Boo");
        //StudentService ss = new StudentService();
        StudentService ss = MyFactory.studentService();
        ss.createStudent("New One", "282 484 9944", Student.Status.FULL_TIME);

        List<Student> students = ss.getAllStudents();
        students.forEach(System.out::println);
    }

    public void getRequestForAllStudents() {
        // Step 1. Define where spring should look for bean definitions
        /*
         * Using XML Config file.
         * ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         */
        /*
         * Using annotation config classes.
         * ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class, OtherConfig.class);
         */
        /*
         * This is a bad design since you would have to spell out every class bean here.
         * Instead use @ComponentScan in the config that will scan for all the classes in the specified pgk and look for @Component annotation
         * ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class, CourseService.class);
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        // Step 2. Instantiate the beans
        StudentService ss = context.getBean("studentService", StudentService.class);
        StudentService ss_duplicate = context.getBean("studentService", StudentService.class);
//        StudentService ss2 = context.getBean("studentService2", StudentService.class);
//        StudentService ss_lazy = context.getBean("studentService_lazy_init", StudentService.class);
        CourseService cs = context.getBean("courseService", CourseService.class);

        // Step 3. Use beans.
        List<Student> students = ss.getAllStudents();
        System.out.println("All Students: " + students.size());
        students.forEach(System.out::println);
    }

    public void getRequestForAllCourses() {
        // Step 1. Define where spring should look for bean definitions
        /*
         * Using XML Config file.
         * ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         */
        /*
         * Using annotation config classes.
         * ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class, OtherConfig.class);
         */
        /*
         * This is a bad design since you would have to spell out every class bean here.
         * Instead use @ComponentScan in the config that will scan for all the classes in the specified pgk and look for @Component annotation
         * ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class, CourseService.class);
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        // Step 2. Instantiate the beans
        CourseService cs = context.getBean("courseService", CourseService.class);

        // Step 3. Use beans.
        List<Course> courses = cs.getAllCourses();
        System.out.println("All Courses: " + courses.size());
        courses.forEach(System.out::println);
    }

    public static void primeAndPrintBoth() {
        //StudentService ss = new StudentService();
        StudentService ss = MyFactory.studentService();
        init(ss);
        List<Student> students = ss.getAllStudents();
        students.forEach(System.out::println);

        CourseService cs = MyFactory.courseService();
        init(cs);
        List<Course> courses = cs.getAllCourses();
        courses.forEach(System.out::println);

    }

    public static void init(StudentService ss) {
        ss.createStudent("Manoj", "282 939 9944", Student.Status.FULL_TIME);
        ss.createStudent("Charlene", "282 898 2145", Student.Status.FULL_TIME);
        ss.createStudent("Firoze", "228 678 8765", Student.Status.HIBERNATING);
        ss.createStudent("Joe", "3838 678 3838", Student.Status.PART_TIME);
    }

    public static void init(CourseService cs) {
        cs.createCourse("Math-101", "Intro To Math");
        cs.createCourse("Math-201", "More Math");
        cs.createCourse("Phys-101", "Baby Physics");
    }
}
