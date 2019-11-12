package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.po.Shop;
import com.po.Users;
@Service("Shopmapper")
public interface IMapper {
	  public int usave(Users user);
	  public Users findByUn(String uname);
	  public int updata(Users user);
	  public int UdelById(String uname);
	  public int findAllRows();
	
	
	
	  public int save(Shop sp);
	  public int update(Shop sp);
	  public int delById(String  sid);
	  public Shop findById(String  sid);
	  public List<Shop> findAll();
	  public List<Shop> findAllPage(Map<String,Object> data);
	  public int findMaxPage(int rows);
}
