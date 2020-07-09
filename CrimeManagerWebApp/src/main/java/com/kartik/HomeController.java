package com.kartik;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.CrimeModel;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String getHome(Model m) {
		m.addAttribute("page", "home");

		return "home";
	}

	@RequestMapping(value = "/delete/{index}", method = RequestMethod.GET)
	public String delete(Model m, @PathVariable(value = "index") String index) {
		int index_no = Integer.parseInt(index);
		List<CrimeModel> list = (List<CrimeModel>) context.getAttribute("list");
		list.remove(index_no);
		m.addAttribute("crimes", list);
		m.addAttribute("page", "view");
		return "home";
	}


@RequestMapping(value = "/editCrime", method = RequestMethod.POST)
public String editCrime(@ModelAttribute("editCrime") CrimeModel t, Model m) {
	
	List<CrimeModel> list = (List<CrimeModel>) context.getAttribute("list");
	int index=Integer.parseInt(t.getIndex());
	String title=t.getCrimeTitle();
	String content=t.getCrimeContent();
	
	ArrayList<Integer> al=new ArrayList();
	int i=0;
	for(CrimeModel cm:list)
	{
		al.add(i);
		i++;
	}
	if(!(al.contains(index-1)))
	{
		return "error";
	}
	CrimeModel cm=new CrimeModel();
	cm.setCrimeTitle(title);
	cm.setCrimeContent(content);
	cm.setDate(new Date());
	list.set(index-1, cm);
	
	
	m.addAttribute("msg", "Crime Updated Successfully");
	return "home";
}

	
	@RequestMapping("/edit")
	public String edit(Model m) {
		CrimeModel editC = new CrimeModel();
		m.addAttribute("page", "edit");
		m.addAttribute("editCrime", editC);
		System.out.println("CAlled");
		return "home";
	}
	
	
	@RequestMapping("/add")
	public String getAdd(Model m) {
		CrimeModel t = new CrimeModel();
		m.addAttribute("page", "add");
		m.addAttribute("crime", t);
		return "home";
	}

	@RequestMapping("/view")
	public String getViewAll(Model m) {
		m.addAttribute("page", "view");
		List<CrimeModel> list = (List<CrimeModel>) context.getAttribute("list");
		m.addAttribute("crimes", list);
		return "home";
	}

	@RequestMapping(value = "/saveCrime", method = RequestMethod.POST)
	public String saveCrime(@ModelAttribute("crime") CrimeModel t, Model m) {
		t.setDate(new Date());
		System.out.println(t);
		List<CrimeModel> list = (List<CrimeModel>) context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "Crime Added Successfully");
		return "home";
	}

}
