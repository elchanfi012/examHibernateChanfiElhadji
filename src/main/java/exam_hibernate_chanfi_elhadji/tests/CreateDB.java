package exam_hibernate_chanfi_elhadji.tests;

import org.hibernate.Session;

import exam_hibernate_chanfi_elhadji.utils.HibernateUtil;


public class CreateDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.close();
	}

}
