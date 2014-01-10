import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Testing {
	public static void main(String[] args)
	{
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		
		System.out.println(sf.openSession().getEntityName("LOAN"));
	}
}
