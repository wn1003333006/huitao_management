package org.java201913.huitao_management.service;

import java.util.List;

import org.java201913.huitao_management.mapper.AdminMapper;
import org.java201913.huitao_management.pojo.Admin;
import org.java201913.huitao_management.pojo.AdminExample;
import org.java201913.huitao_management.pojo.AdminExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
   @Autowired
   private AdminMapper am;
   
   public List<Admin>  login(Admin a){
	   AdminExample ae=new AdminExample();
	   Criteria c =ae.createCriteria();
	   c.andAdNameEqualTo(a.getAdName());
	   c.andAdPassEqualTo(a.getAdPass());
	   return am.selectByExample(ae);
   }
}
