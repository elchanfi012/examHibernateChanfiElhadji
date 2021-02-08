package exam_hibernate_chanfi_elhadji.sevices;


import org.hibernate.SessionFactory;


import exam_hibernate_chanfi_elhadji.utils.HibernateUtil;

public class ColorService {
	private SessionFactory sessionFectory;

	public ColorService() {
		this.sessionFectory = HibernateUtil.getSessionFactory();
		
		
	}
	
	
}
