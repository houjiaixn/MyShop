package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IBiz;
import com.mapper.IMapper;
import com.po.*;
@Service("ShopBiz")
@Transactional
public class ShopBiz implements IBiz {
	@Resource(name="Shopmapper")
	private IMapper  Mapper;
	
	public boolean usave(Users user) {
		boolean flag=false;
		if(user!=null){
			int rowss=Mapper.findAllRows();
			System.out.println(rowss);
			if(rowss>4){
				flag=false;
			}else {
			int rows = Mapper.usave(user);
		  if(rows>0) {
			  flag=true;
		  }
			}
		}
		return flag;
	}


	public Users findByUn(String uname) {
		// TODO Auto-generated method stub
		return Mapper.findByUn(uname);
	}

	public boolean updata(Users user) {
		boolean flag=false;
		if(user!=null){
			int rows = Mapper.updata(user);
			if(rows>0) {
				flag=true;
			}
		}
		return flag;
	}


	public boolean UdelById(String uname) {
		boolean flag=false;
			int rows = Mapper.delById(uname);
			if(rows>0) {
				flag=true;
			}
		return flag;
	}

	
	
	
	
	public boolean save(Shop sp) {
		boolean flag=false;
		if(sp!=null){
			System.out.println("保存");
			int rows = Mapper.save(sp);
		  if(rows>0) {
			  flag=true;
		  }
		}
		return flag;
	}

	public boolean update(Shop sp) {
		boolean flag=false;
		if(sp!=null){
			int rows = Mapper.update(sp);
			if(rows>0) {
				flag=true;
			}
		}
		return flag;
	}

	public boolean delById(String sid) {
		boolean flag=false;
		int rows = Mapper.delById(sid);
		if(rows>0){
			flag=true;
		}
		return flag;
	}

	public Shop findById(String sid) {
		return Mapper.findById(sid);
	}

	public List<Shop> findAll() {
		return Mapper.findAll();
	}

	public List<Shop> findAllPage(int page, int rows) {
		Map<String, Object> data = new HashMap();
        data.put("page", (page-1)*rows);
        data.put("rows", rows);
		return Mapper.findAllPage(data);
	}

	public int findMaxPage(int rows) {
		int maxrows=0;//总记录数
		int maxpage=0;//总页数
		maxrows=Mapper.findMaxPage(rows);
		if(maxrows==0){
			maxpage=1;
		}else{
			maxpage=maxrows%rows==0?maxrows/rows:maxrows/rows+1;
		}
		return maxpage;
	}

	public IMapper getIMapper() {
		return Mapper;
	}

	public void setMapper(IMapper mapper) {
		Mapper = mapper;
	}
	
	
}
