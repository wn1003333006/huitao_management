package org.java201913.huitao_management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.java201913.huitao_management.pojo.Brand;
import org.java201913.huitao_management.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private BrandService bs;
	
	@RequestMapping("showall")
	public String showall(int page,HttpServletRequest request){
		int pagesize=10;
		//数据
		List<Brand> list=bs.showAll(page, pagesize);
		//总条数
		long counts =bs.counts();
		request.setAttribute("list", list);
		request.setAttribute("counts", counts);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("page", page);
		
		return "BrandShow";
	}
	
	
	//ajax 验证 bname  0否 1是
	@RequestMapping("showByBnameAjax")
	@ResponseBody
	public Integer showByBnameAjax(String bname){
		List<Brand> list =bs.showByBname(bname);
		if(list.isEmpty()){
			return 1;
		}else{
            return 0;
		}
		
	}
	
	@RequestMapping("insert")
	public String insert(Brand b,int page){
		int i=bs.insert(b);
		//操作完毕后，要再次查询一下，更新数据
		return "redirect:/brand/showall?page="+page;
	}
	
	@RequestMapping("update")
	public String update(Brand b,int page){
		int i=bs.update(b);
		//操作完毕后，要再次查询一下，更新数据
		return "redirect:/brand/showall?page="+page;
	}
	
	@RequestMapping("delete")
	public String update(int id,long page){
		int i=bs.delete(id);
		int pagesize=10;
		//总条数
		long counts =bs.counts();
		//计算一下是否可以回显到page页
		long pageCount=counts%pagesize==0?counts/pagesize:(counts/pagesize)+1;
		//如果页数不足了，回显到最后一页
		if(pageCount<page){
			page=pageCount;
		}
		
		//操作完毕后，要再次查询一下，更新数据
		return "redirect:/brand/showall?page="+page;
	}
	
	
}
