package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Shop;
import com.po.Users;

public interface IShopAction {
	  public String usave(HttpServletRequest request, HttpServletResponse response, Users user);
	  public String UfindById(HttpServletRequest request, HttpServletResponse response, String  Uname);
	  public String findByUn(HttpServletRequest request, HttpServletResponse response, String uname);
	  public String updata(HttpServletRequest request, HttpServletResponse response, Users user);
	  public String UdelById(HttpServletRequest request, HttpServletResponse response, String uname);
	
	
	
	  public String save(HttpServletRequest request, HttpServletResponse response, Shop sp);
	  public String update(HttpServletRequest request, HttpServletResponse response, Shop sp);
	  public String delById(HttpServletRequest request, HttpServletResponse response, String  sid);
	  public String findById(HttpServletRequest request, HttpServletResponse response, String  sid);
	  public String findAllPage(HttpServletRequest request, HttpServletResponse response, Integer page,Integer rows);
}
