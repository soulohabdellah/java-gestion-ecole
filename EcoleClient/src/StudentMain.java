import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Student;

public class StudentMain {

    public static IDao<Student> lookUpStudentRemote() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        final Context context = new InitialContext(jndiProperties);
        return (IDao<Student>) context.lookup("ejb:/EcoleServer/StudentService!dao.IDao");
    }

    public static void main(String[] args) {
        try {
            IDao<Student> dao = lookUpStudentRemote();
            dao.create(new Student("Souloh", "1234", "Souloh", "Abdellah", "0611917984", null));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
