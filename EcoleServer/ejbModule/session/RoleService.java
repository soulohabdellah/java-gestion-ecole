package session;

import java.util.List;

import dao.IDao;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class RoleService implements IDao<Role> {

    @PersistenceContext
    private EntityManager em;

	@Override
	@PermitAll    public boolean create(Role role) {
        try {
            em.persist(role);
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }

	@Override
	@PermitAll    public boolean update(Role role) {
        try {
            em.merge(role); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll
    public boolean delete(Role role) {
        try {
            em.remove(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public Role findById(int id) {
        return em.find(Role.class, id);
    }

	@Override
	@PermitAll    public List<Role> findAll() {
        jakarta.persistence.Query query = em.createQuery("SELECT r FROM Role r", Role.class);
        return query.getResultList();
    }
}
