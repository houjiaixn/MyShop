package com.biz;

import java.util.List;

import com.po.*;


public interface IBiz {
	  public boolean usave(Users user);
	  public Users findByUn(String uname);
	  public boolean updata(Users user);
	  public boolean UdelById(String uname);
	
	
	
	  public boolean save(Shop sp);
	  public boolean update(Shop sp);
	  public boolean delById(String  sid);
	  public Shop findById(String  sid);
	  public List<Shop> findAll();
	  public List<Shop> findAllPage(int page,int rows);
	  public int findMaxPage(int rows);
}
