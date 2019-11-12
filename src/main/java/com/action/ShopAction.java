package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.biz.IBiz;
import com.po.PageBean;
import com.po.Shop;
import com.po.Users;


@Controller
public class ShopAction implements IShopAction {
	@Resource(name="ShopBiz")
	  private IBiz iBiz;
	private HttpSession session;
	
	
	
	
	public IBiz getiBiz() {
		return iBiz;
	}

	public void setiBiz(IBiz iBiz) {
		this.iBiz = iBiz;
	}

	@RequestMapping(value="usave_Shop.do")
	public String usave(HttpServletRequest request, HttpServletResponse response, Users user) {
		String uname=request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String queshion = request.getParameter("queshion");
		String answer = request.getParameter("answer");
		System.out.println(uname+upassword+queshion+answer);
		user= new Users(uname,upassword,queshion,answer);
		boolean flag=iBiz.usave(user);
		System.out.println(flag);
		if(flag){
			session = request.getSession();
			session.setAttribute("success", "注册成功！");
			return "redirect:login.jsp";
		}else{
			session.setAttribute("message", "账户超过五个，注册失败！");
			return "redirect:register.jsp";
		}
	}

	@RequestMapping(value="UfindById_Shop.do")
	public String UfindById(HttpServletRequest request, HttpServletResponse response, String uname) {
		uname=request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		Users olduser = iBiz.findByUn(uname);
		System.out.println(uname+upassword);
		System.out.println(olduser.getUname()+olduser.getUpassword());
		if(uname.equals(olduser.getUname())&&upassword.equals(olduser.getUpassword())){
			session = request.getSession();
			session.setAttribute("success", "登录成功！");
			System.out.println("登陆成功");
			return "redirect:add.jsp";
		}else {
			session.setAttribute("message", "登陆失败，账号或者密码错误！");
			return "redirect:register.jsp";
		}
	}

	@RequestMapping(value="findByUn_Shop.do")
	public String findByUn(HttpServletRequest request, HttpServletResponse response, String uname) {
		uname=request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String queshion = request.getParameter("queshion");
		String answer = request.getParameter("answer");
		Users olduser=iBiz.findByUn(uname);
		if(uname.equals(olduser.getUname())&&
				upassword.equals(olduser.getUpassword())&&
				queshion.equals(olduser.getQueshion())&&
				answer.equals(olduser.getAnswer())){
			return "redirect:newuser.jsp";
		}
		return null;
	}

	@RequestMapping(value="updata_Shop.do")
	public String updata(HttpServletRequest request, HttpServletResponse response, Users user) {
		String uname =request.getParameter("uname");
		String upassword1 = request.getParameter("upassword1");
		String upassword2 = request.getParameter("upassword2");
		if(upassword1.equals(upassword2)){
			user = new Users(uname,upassword1);
			boolean flag = iBiz.updata(user);
			if(flag){
				session = request.getSession();
				session.setAttribute("success", "修改成功，请重新登录");
				return "redirect:login.jsp";
			}else{
				session.setAttribute("message", "修改失败，请注册");
				return "redirect:register.jsp";
			}
		}
		return null;
	}

	@RequestMapping(value="UdelById_Shop.do")
	public String UdelById(HttpServletRequest request, HttpServletResponse response, String uname) {
		//注销页面
		uname=request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String queshion = request.getParameter("queshion");
		String answer = request.getParameter("answer");
		Users olduser=iBiz.findByUn(uname);
		if(uname.equals(olduser.getUname())&&
				upassword.equals(olduser.getUpassword())&&
				queshion.equals(olduser.getQueshion())&&
				answer.equals(olduser.getAnswer())){
			boolean flag=iBiz.UdelById(olduser.getUname());
			if(flag){
				session = request.getSession();
				session.setAttribute("message", "注销成功！");
				   return "redirect:register.jsp";
			   }else{
				   session.setAttribute("success", "请重新登录！");
				   return "redirect:login.jsp";
			   }
		}
		return null;
	}

	@RequestMapping(value="save_Shop.do")
	public String save(HttpServletRequest request, HttpServletResponse response, Shop sp) {
		String realpath=request.getRealPath("/");
	     /**********文件上传************/
	     //获取上传照片对象
	     MultipartFile multipartFile=sp.getPic();
	     if(multipartFile!=null&&!multipartFile.isEmpty()){
	    	 //获取上传文件名称
	    	 String imgname=multipartFile.getOriginalFilename();
	    	 //更名
	    	 if(imgname.lastIndexOf(".")!=-1){
	    		 //获取后缀
	    		 String ext=imgname.substring(imgname.lastIndexOf("."));
	    		 //判断后缀格式
	    		 if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
	    			 //改名
	    			 String newimgname=sp.getSname()+ext;
	    			 //创建文件对象，指定上传文件的路径
	    			 File dostFile=new File(realpath+"/shop/"+newimgname);
	    			 //上传
	    			 try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
						 sp.setImgname(newimgname);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		 }
	    	 }
	     }
	     /**********文件上传end************/
	     boolean flag=iBiz.save(sp);
	     if(flag){
	    	 session = request.getSession();
	    	 session.setAttribute("success", "添加商品成功！");
	    	 return "redirect:findAllPage_Shop.do";
	     }
	     session.setAttribute("success", "添加商品失败！");
		return "redirect:add.jsp";
	}

	@RequestMapping(value="update_Shop.do")
	public String update(HttpServletRequest request, HttpServletResponse response, Shop sp) {
		//获取原来的照片，在不修改照片的时候，展示原来的照片
		String oldimgname=iBiz.findById(sp.getSid()).getImgname();
		 String realpath=request.getRealPath("/");
		  /**********文件上传************/
	     //获取上传照片对象
	     MultipartFile multipartFile=sp.getPic();
	     if(multipartFile!=null&&!multipartFile.isEmpty()){
	    	 //获取上传文件名称
	    	 String imgname=multipartFile.getOriginalFilename();
	    	 //更名
	    	 if(imgname.lastIndexOf(".")!=-1){
	    		 //获取后缀
	    		 String ext=imgname.substring(imgname.lastIndexOf("."));
	    		 //判断后缀格式
	    		 if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
	    			 //改名
	    			 String newimgname=sp.getSname()+ext;
	    			 //创建文件对象，指定上传文件的路径
	    			 File dostFile=new File(realpath+"/shop/"+newimgname);
	    			 //上传
	    			 try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
						 System.out.println("文件上传成功");
						  sp.setImgname(newimgname);
						 //删除原来的照片，获取原来的文件对象
						 File oldfile=new File(realpath+"/shop/"+oldimgname);
						 if(oldfile.exists()&&!oldfile.equals("default.jpg")){
							 oldfile.delete();//删除原来的
						 }
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		 }
	    	 }
	     }else{
	    	 //没有文件上传
	    	 sp.setImgname(oldimgname);
	     }
	     /**********文件上传end************/
	     boolean flag=iBiz.update(sp);
	     if(flag){
	    	 return "redirect:findAllPage_Shop.do";
	     }
	     
		return "redirect:add.jsp";
	}

	@RequestMapping(value="delById_Shop.do")
	public String delById(HttpServletRequest request, HttpServletResponse response, String sid) {
		//获取原来的照片，在不修改照片的时候，展示原来的照片
		String oldimgname=iBiz.findById(sid).getImgname();
		 String realpath=request.getRealPath("/");
		 boolean flag=iBiz.delById(sid);
		 if(flag){
			 //删除照片
			 File oldfile=new File(realpath+"/SHOP/"+oldimgname);
			 if(oldfile.exists()&&!oldfile.equals("default.jpg")){
				 oldfile.delete();//删除原来的
			 }
			 return "redirect:findAllPage_Shop.do";
		 }
		 
		 return "redirect:add.jsp";
	}

	@RequestMapping(value="findById_Shop.do")
	public String findById(HttpServletRequest request, HttpServletResponse response, String sid) {
		sid=request.getParameter("sid");
		Shop oldsp=iBiz.findById(sid);
		session.setAttribute("oldsp", oldsp);
		return "redirect:updata.jsp";
	}

	@RequestMapping(value="findAllPage_Shop.do")
	public String findAllPage(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		session=request.getSession();
		//从session中获取pb对象
		PageBean pb=(PageBean)session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		page=page==null || page<1?pb.getPage():page;
		rows=rows==null || rows<1?pb.getRows():rows;
		if(page<1)page=1;
		if(rows<1)rows=5;
		//获取总页数
		int maxpage=iBiz.findMaxPage(rows);
		if(page>maxpage)page=maxpage;
		//获取当前页记录集合
		List<Shop> list=iBiz.findAllPage(page, rows);
		//检查分页数据封装pb对象
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(list);
		session.setAttribute("pb", pb);
		Object success = session.getAttribute("success");
		List<Shop> slist=iBiz.findAll();
		session.setAttribute("success",success);
		session.setAttribute("slist", slist);
		session.setAttribute("list", list);
		return "Shop.jsp";
	}
}
