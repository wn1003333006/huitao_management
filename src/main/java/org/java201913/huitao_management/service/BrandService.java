package org.java201913.huitao_management.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.java201913.huitao_management.mapper.BrandMapper;
import org.java201913.huitao_management.pojo.Brand;
import org.java201913.huitao_management.pojo.BrandExample;
import org.java201913.huitao_management.pojo.BrandExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

	@Autowired
	private BrandMapper bm;
	
	//分页查看
	public List<Brand> showAll(int page,int pagesize){
		RowBounds rb =new RowBounds((page-1)*pagesize, pagesize);
		return bm.selectByExampleWithRowbounds(null, rb);
	}
	
	//计算总条数
	public long counts(){
		return bm.countByExample(null);
	}
	
	
	//根据bname查询的方法
	public  List<Brand> showByBname(String bname){
		BrandExample be =new BrandExample();
		Criteria c =be.createCriteria();
		c.andBnameEqualTo(bname);
		return bm.selectByExample(be);
	}
	
	public int insert(Brand b){
		return bm.insertSelective(b);
	}
	
	public int update(Brand b){
		return bm.updateByPrimaryKeySelective(b);
	}
	public int delete(int id){
		return bm.deleteByPrimaryKey(id);
	}
	
	public List<Brand> show(){
		return bm.selectByExample(null);
	}
}
