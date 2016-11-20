package com.sv.udb.controlador;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sv.udb.modelo.Alumnos;
import com.sv.udb.utils.HibernateUtil;
/**
 * Home object for domain model class Alumnos.
 * @see .Alumnos
 * @author Hibernate Tools
 */
@Stateless
public class AlumnosBeans extends HibernateUtil {


	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Alumnos transientInstance) {
		try {
			entityManager.persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void remove(Alumnos persistentInstance) {
		try {
			entityManager.remove(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Alumnos merge(Alumnos detachedInstance) {
		try {
			Alumnos result = entityManager.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Alumnos findById(Integer id) {
		try {
			Alumnos instance = entityManager.find(Alumnos.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public ArrayList<Alumnos> findAll() {
        try
        {
        	ArrayList<Alumnos> list = new ArrayList<Alumnos>();
        	list = (ArrayList<Alumnos>)entityManager.createQuery("from Alumnos").getResultList();
        	return list;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
