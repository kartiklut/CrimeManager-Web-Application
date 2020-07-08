package com.kartik;

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
	public String getHome(Model m)
	{
		m.addAttribute("page","home");
		
		
		return "home";
	}
	
	@RequestMapping(value="/delete/{index}", method=RequestMethod.GET)
	public String delete(Model m ,@PathVariable(value="index") String index)
	{
		int index_no=Integer.parseInt(index);
		List<CrimeModel> list=(List<CrimeModel>)context.getAttribute("list");
		list.remove(index_no);
		m.addAttribute("crimes", list);
		return "home";
	}
	
	
	
	@RequestMapping("/add")
	public String getAdd(Model m)
	{
		CrimeModel t=new CrimeModel();
		m.addAttribute("page","add");
		m.addAttribute("crime",t);
		return "home";
	}
	
	@RequestMapping("/view")
	public String getViewAll(Model m)
	{
		m.addAttribute("page","view");
		List<CrimeModel> list=(List<CrimeModel>)context.getAttribute("list");
		m.addAttribute("crimes", list);
		return "home";
	}
	 
	@RequestMapping(value ="/saveCrime" ,method=RequestMethod.POST)  
	public String saveTodo(@ModelAttribute("crime") CrimeModel t,Model m) 
	{
		t.setDate(new Date());
		System.out.println(t);
		List<CrimeModel> list=(List<CrimeModel>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg","Crime Added Successfully");
		return "home";
	}

}
