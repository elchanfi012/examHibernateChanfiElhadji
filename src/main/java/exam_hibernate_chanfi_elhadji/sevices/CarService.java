package exam_hibernate_chanfi_elhadji.sevices;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import exam_hibernate_chanfi_elhadji.utils.HibernateUtil;


public class CarService {
	private SessionFactory sessionFectory;

	public CarService() {
		this.sessionFectory = HibernateUtil.getSessionFactory();
	}
	
	public List<?> getAll(){
		Session session = this.sessionFectory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM Car C";
		Query<?> query = session.createQuery(hql);
		List<?> cars = query.getResultList();
		session.close();
		return  cars;
	}

	
	public List<?> getMarqueList(){
		Session session = this.sessionFectory.getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT C.marque FROM Car C GROUP BY C.marque";
		Query<?> query = session.createQuery(hql);
		List<?> marques = query.getResultList();
		session.close();
		return  marques;
	}
	
	public Long getNbCars() {
		Session session = this.sessionFectory.getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT COUNT(*) FROM Car C";
		Query<?> query = session.createQuery(hql);
		Long nbCars = (Long) query.getSingleResult();
		session.close();
		return  nbCars;
	}
	
	
	public List<?> getTenLatestCarAdd(){
		Session session = this.sessionFectory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM Car C ORDER BY C.dateAjout DESC";
		Query<?> query = session.createQuery(hql);
		query.setMaxResults(10);
		List<?> cars = query.getResultList();
		session.close();
		return  cars;
	}
}
