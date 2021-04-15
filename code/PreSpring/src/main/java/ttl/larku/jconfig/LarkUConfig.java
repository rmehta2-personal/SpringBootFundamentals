package ttl.larku.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

@Configuration
@ComponentScan({"ttl.larku.service", "ttl.larku.dao"})
public class LarkUConfig {
    private static final String propertiesFile = "larkUContext";
    private static final String profile = "larku.profile.active";

//    <bean id="inMemoryStudentDao" class="ttl.larku.dao.inmemory.InMemoryStudentDAO"/>
    @Bean
    public BaseDAO<Student> inMemoryStudentDao() {
//        return MyFactory.studentDAO();
        return new InMemoryStudentDAO();
    }

//    <bean id="studentService" class="ttl.larku.service.StudentService">
//        <property name="studentDAO" ref="inMemoryStudentDao"/>
//    </bean>
    @Bean
    public StudentService studentService() {
        StudentService ss = new StudentService();
        BaseDAO<Student> sdao = inMemoryStudentDao();
        ss.setStudentDAO(sdao);
        return ss;
    }
}