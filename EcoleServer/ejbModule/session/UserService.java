package session;

import java.util.List;

import dao.IDao;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class UserService implements IDao<User> {

    @PersistenceContext
    private EntityManager em;
	@PermitAll
    @Override
    public boolean create(User user) {
        try {
            em.persist(user);
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }

	@Override
	@PermitAll    
	public boolean update(User user) {
        try {
            em.merge(user); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    
	public boolean delete(User user) {
        try {
            em.remove(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public User findById(int id) {
        return em.find(User.class, id);
    }

	@Override
	@PermitAll
	public List<User> findAll() {
		jakarta.persistence.Query query = em.createQuery("select u from User u");
		return query.getResultList();		
	}
}
