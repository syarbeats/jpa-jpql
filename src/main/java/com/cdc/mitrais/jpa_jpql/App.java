package com.cdc.mitrais.jpa_jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdc.mitrais.jpa_jpql.entity.Employee;
import com.cdc.mitrais.jpa_jpql.entity.NonTeachingStaff;
import com.cdc.mitrais.jpa_jpql.entity.TeachingStaff;

public class App 
{
    public static void main( String[] args )
    {
    	/*************************************************
    	 * JPA NAMED QUERIES
    	 *************************************************/
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	EntityManager entitymanager = emFactory.createEntityManager();
    	Query query = entitymanager.createNamedQuery("find employee by id");
    	
    	query.setParameter("id", 1204);
    	List<Employee> employeeList = query.getResultList();
    	
    	for(Employee emp : employeeList) {
    		System.out.println("Employee Name:"+emp.getEname());
    	}
    	
    	/***************************************************
    	 * ADVANCE MAPPING
    	 ***************************************************/
        entitymanager.getTransaction().begin();
        TeachingStaff ts1=new TeachingStaff(1,"Gopal","MSc MEd","Maths");
        TeachingStaff ts2=new TeachingStaff(2, "Manisha", "BSc BEd", "English");
        
        //Non-Teaching Staff entity
        NonTeachingStaff nts1=new NonTeachingStaff(3, "Satish", "Accounts");
        NonTeachingStaff nts2=new NonTeachingStaff(4, "Krishna", "Office Admin");

        //storing all entities
        entitymanager.persist(ts1);
        entitymanager.persist(ts2);
        entitymanager.persist(nts1);
        entitymanager.persist(nts2);
        entitymanager.getTransaction().commit();
        
        entitymanager.close();
        emFactory.close();
    }
}
