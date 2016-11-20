package com.sv.udb.controlador;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sv.udb.modelo.Usuarios;
import com.sv.udb.utils.HibernateUtil;

/**
 * Home object for domain model class Usuarios.
 * @see .Usuarios
 * @author Hibernate Tools
 */
@Stateless
public class UsuariosBeans extends HibernateUtil {


	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usuarios transientInstance) {
		try {
			entityManager.persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void remove(Usuarios persistentInstance) {
		try {
			entityManager.remove(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Usuarios merge(Usuarios detachedInstance) {
		try {
			Usuarios result = entityManager.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Usuarios findById(Integer id) {
		try {
			Usuarios instance = entityManager.find(Usuarios.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public ArrayList<Usuarios> findAll() {
        try
        {
           return (ArrayList<Usuarios>)entityManager.createQuery("from Usuarios").getResultList();
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
