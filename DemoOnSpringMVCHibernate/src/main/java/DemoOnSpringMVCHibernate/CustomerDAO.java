package DemoOnSpringMVCHibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAO {
HibernateTemplate template;

public HibernateTemplate getTemplate() {
	return template;
}

public void setTemplate(HibernateTemplate template) {
	this.template = template;
}
//method to save employee
public void insert(Customer e)
{
	template.save(e);
}
//method to update employee
public void update(Customer e)
{
	template.update(e);
	
}
//method to get an employee object based on empid
public Customer getEmployeeById(int empid)
{
	Customer e= (Customer)template.get(Customer.class,empid);
	return e;
}
public void delete(int empid)
{
	Customer e= (Customer)template.get(Customer.class,empid);
	template.delete(e);
	
}
//list of employees
public List<Customer> getEmployeeList()
{
	List<Customer> l=(List<Customer>)template.find("from Employee");
	return l;
}

}
