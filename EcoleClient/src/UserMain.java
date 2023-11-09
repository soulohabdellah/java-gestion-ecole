import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.User;

public class UserMain {

public static IDao<User> lookUpUserRemote() throws NamingException {
		
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);
		return (IDao<User>) context.lookup("ejb:/EcoleServer/UserService!dao.IDao");

	}

	public static void main(String[] args) {

		try {
			IDao<User> dao = lookUpUserRemote();
			dao.create(new User("soloh","123"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}


}
