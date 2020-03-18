package org.java201913.huitao_management.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.java201913.huitao_management.mapper.StylechildMapper;
import org.java201913.huitao_management.pojo.Stylechild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleChildService {

	@Autowired
	private StylechildMapper scm;
	
	public List<Stylechild> showAll(int page,int pagesize){
		RowBounds rb =new RowBounds((page-1)*pagesize,pagesize);
		return scm.showAll(rb);
	}
	public long counts(){
	   return scm.countByExample(null);
	}
}
