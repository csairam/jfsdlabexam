package DemoOnSpringMVCHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	@Autowired
	CustomerDAO dao;
	@GetMapping("/add")
	public String Add(Model m)
	{
		Customer e = new Customer();
		m.addAttribute("command",e);
		return "add";
		}
	@PostMapping("/save")
	public String Save(@ModelAttribute ("e") Customer e )
	{
		dao.insert(e);
		return "redirect:/show";
		
	}
	@GetMapping("/show")
public String show(Model m)
{
   m.addAttribute("emplist", dao.getEmployeeList());
	return "show";
}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id,Model m)
	{
		Customer e= dao.getEmployeeById(id);
		m.addAttribute("editdata", e);
		return "edit";
	}
	@PostMapping("/editsave")
	public String update(Customer e)
	{
		dao.update(e);
		return "redirect:/show";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")int  id)
	{
		dao.delete(id);
		return "redirect:/show";
	}
}
