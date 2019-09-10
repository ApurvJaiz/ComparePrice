package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Entities.Product;
import service.AddServiceAmazon;
import service.AddServiceEbay;
import service.AddServiceFlipkart;

@Controller
public class AddController 
{
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView(); 
		String i=request.getParameter("t1");
		AddServiceFlipkart ad=new AddServiceFlipkart();
		AddServiceAmazon ad2=new AddServiceAmazon();
		AddServiceEbay ad3=new AddServiceEbay();
		Product f=new Product();
		Product a=new Product();
		Product eb=new Product();
		try {
			f=ad.add(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error404.jsp");
			mv.addObject("error", f.getName());
			return mv;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error.jsp");
			return mv;
		}
		
		try {
			a=ad2.add(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error404.jsp");
			mv.addObject("error", a.getName());
			return mv;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error.jsp");
			return mv;
		}
		try {
			eb=ad3.add(i);
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error404.jsp");
			mv.addObject("error", eb.getName());
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.setViewName("Error.jsp");
			return mv;
		}
		System.out.println(eb.getPrice()+"\n"+eb.getProduct());
		mv.setViewName("display.jsp");
		mv.addObject("productf",f.getProduct());
		mv.addObject("pricef",f.getPrice());
		mv.addObject("urlf",f.getUrl());
		mv.addObject("producta",a.getProduct());
		mv.addObject("pricea",a.getPrice());
		mv.addObject("imagea",a.getImage());
		mv.addObject("urla",a.getUrl());
		mv.addObject("producte",eb.getProduct());
		mv.addObject("pricee",eb.getPrice());
		mv.addObject("urle",eb.getUrl());
		return mv;
	}

}
