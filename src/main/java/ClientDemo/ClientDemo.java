package ClientDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ClientDemo {

	public static void main(String arg[]) {
	ClientDemo op= new ClientDemo();
	op.aggregatefunctions();
	}
	


public void aggregatefunctions()
{
	
	Configuration config = new Configuration();
       config.configure("hibernate.cfg.xml");
       
       SessionFactory sf = config.buildSessionFactory();
       Session session = sf.openSession();
       
       //count
       CriteriaBuilder cb1=session.getCriteriaBuilder();
       CriteriaQuery<Long> cq1=cb1.createQuery(Long.class);  
       Root<Project> root1=cq1.from(Project.class);
       cq1.select(cb1.count(root1.get("name"))); 
       Long count=session.createQuery(cq1).getSingleResult();
       System.out.println("Total Projects Count="+count);
       
       //sum
       CriteriaBuilder cb2=session.getCriteriaBuilder();
       CriteriaQuery<Double> cq2=cb1.createQuery(Double.class);  
       Root<Project> root2=cq2.from(Project.class);
       cq2.select(cb2.sum(root2.get("budget"))); 
       double budget=session.createQuery(cq2).getSingleResult();
       System.out.println("Total Budget="+budget);
       
       //avg
       CriteriaBuilder cb3=session.getCriteriaBuilder();
       CriteriaQuery<Double> cq3=cb3.createQuery(Double.class); 
       Root<Project> root3=cq3.from(Project.class);
       cq3.select(cb3.avg(root3.get("budget"))); 
       double avgbudget=session.createQuery(cq3).getSingleResult();
       System.out.println("Average Budget="+avgbudget);
       
       //min
       CriteriaBuilder cb4=session.getCriteriaBuilder();
       CriteriaQuery<Integer> cq4=cb4.createQuery(Integer.class); 
       Root<Project> root4=cq4.from(Project.class);
       cq4.select(cb4.min(root4.get("duration"))); 
       int minduration=session.createQuery(cq4).getSingleResult();
       System.out.println("Minimum duration in project is ="+minduration);
       
       //max
       
       CriteriaBuilder cb5=session.getCriteriaBuilder();
       CriteriaQuery<Integer> cq5=cb5.createQuery(Integer.class);   //Integer class should be taken
       Root<Project> root5=cq5.from(Project.class);
       cq5.select(cb5.max(root5.get("duration"))); 
       int maxduration=session.createQuery(cq5).getSingleResult();
       System.out.println("Maximum duration of project is "+maxduration);
       
       
     
       
       
       session.close();
       sf.close();	 
}


}
