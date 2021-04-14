package ttl.larku.service.factory;

import ttl.larku.dao.factory.StudentDAOFactory;
import ttl.larku.dao.interfaces.StudentDAOInterface;
import ttl.larku.service.StudentService;

import java.util.ResourceBundle;

public class StudentServiceFactory {

    private static final String propertiesFile = "larkUContext";
    private static final String profile = "larku.profile.active";

    public static StudentService getStudentService() {
        StudentDAOInterface dao = StudentDAOFactory.getStudentDAO();
        ResourceBundle bundle = ResourceBundle.getBundle(propertiesFile);
        String activeProfile = bundle.getString(profile);
        switch(activeProfile)
        {
            case "dev":
                System.out.println("Using StudenService for profile "+activeProfile);
                return new StudentService(dao);
            case"prod":
                System.out.println("Using JpaStudentDAO for profile "+activeProfile);
                return new StudentService(dao);
            default:
                throw new RuntimeException("Unknown profile "+ activeProfile);
        }
    }
}
