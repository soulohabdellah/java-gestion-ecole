import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Filiere;

public class FiliereMain {

    public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        final Context context = new InitialContext(jndiProperties);
        return (IDao<Filiere>) context.lookup("ejb:/EcoleServer/FiliereService!dao.IDao");
    }

    public static void main(String[] args) {
        try {
            IDao<Filiere> dao = lookUpFiliereRemote();
            dao.create(new Filiere("IIR", "IT"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
