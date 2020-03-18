package org.java201913.huitao_management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.java201913.huitao_management.pojo.Brand;
import org.java201913.huitao_management.pojo.Stylechild;
import org.java201913.huitao_management.service.BrandService;
import org.java201913.huitao_management.service.StyleChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("stylechild")
public class StyleChildController {

	@Autowired
	private StyleChildService scs;
	@Autowired
	private BrandService bs; 
	
	
	@RequestMapping("showAll")
	public String showAll(int page,HttpServletRequest request){
		int pagesize=10;
		List<Stylechild> list=scs.showAll(page, pagesize);
		long counts=scs.counts();
		
		//查询品牌
		List<Brand> blist=bs.show();
		
		request.setAttribute("blist", blist);
		request.setAttribute("list", list);
		request.setAttribute("counts", counts);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("page", page);
		return "styleChild";
	}
	
}
