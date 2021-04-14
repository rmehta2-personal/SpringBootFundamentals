package ttl.larku.dao.factory;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.dao.interfaces.StudentDAOInterface;
import ttl.larku.dao.jpa.JpaStudentDAO;

import java.util.ResourceBundle;

public class StudentDAOFactory {

    private static final String propertiesFile = "larkUContext";
    private static final String profile = "larku.profile.active";

    public static StudentDAOInterface getStudentDAO() {
        ResourceBundle bundle = ResourceBundle.getBundle(propertiesFile);
        String activeProfile = bundle.getString(profile);
        switch(activeProfile)
        {
            case "dev":
                System.out.println("Using InMemoryStudentDAO for profile "+activeProfile);
                return new InMemoryStudentDAO();
            case"prod":
                System.out.println("Using JpaStudentDAO for profile "+activeProfile);
                return new JpaStudentDAO();
            default:
                throw new RuntimeException("Unknown profile "+ activeProfile);
        }
    }
}
