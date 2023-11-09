package session;

import java.util.List;

import dao.IDao;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class StudentService implements IDao<Student> {

    @PersistenceContext
    private EntityManager em;

	@Override
	@PermitAll    public boolean create(Student student) {
        try {
            em.persist(student);
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }

	@Override
	@PermitAll    public boolean update(Student student) {
        try {
            em.merge(student); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public boolean delete(Student student) {
        try {
            em.remove(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public Student findById(int id) {
        return em.find(Student.class, id);
    }

	@Override
	@PermitAll    public List<Student> findAll() {
        jakarta.persistence.Query query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }
}
