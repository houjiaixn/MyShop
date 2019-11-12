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
			session.setAttribute("success", "ע��ɹ���");
			return "redirect:login.jsp";
		}else{
			session.setAttribute("message", "�˻����������ע��ʧ�ܣ�");
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
			session.setAttribute("success", "��¼�ɹ���");
			System.out.println("��½�ɹ�");
			return "redirect:add.jsp";
		}else {
			session.setAttribute("message", "��½ʧ�ܣ��˺Ż����������");
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
				session.setAttribute("success", "�޸ĳɹ��������µ�¼");
				return "redirect:login.jsp";
			}else{
				session.setAttribute("message", "�޸�ʧ�ܣ���ע��");
				return "redirect:register.jsp";
			}
		}
		return null;
	}

	@RequestMapping(value="UdelById_Shop.do")
	public String UdelById(HttpServletRequest request, HttpServletResponse response, String uname) {
		//ע��ҳ��
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
				session.setAttribute("message", "ע���ɹ���");
				   return "redirect:register.jsp";
			   }else{
				   session.setAttribute("success", "�����µ�¼��");
				   return "redirect:login.jsp";
			   }
		}
		return null;
	}

	@RequestMapping(value="save_Shop.do")
	public String save(HttpServletRequest request, HttpServletResponse response, Shop sp) {
		String realpath=request.getRealPath("/");
	     /**********�ļ��ϴ�************/
	     //��ȡ�ϴ���Ƭ����
	     MultipartFile multipartFile=sp.getPic();
	     if(multipartFile!=null&&!multipartFile.isEmpty()){
	    	 //��ȡ�ϴ��ļ�����
	    	 String imgname=multipartFile.getOriginalFilename();
	    	 //����
	    	 if(imgname.lastIndexOf(".")!=-1){
	    		 //��ȡ��׺
	    		 String ext=imgname.substring(imgname.lastIndexOf("."));
	    		 //�жϺ�׺��ʽ
	    		 if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
	    			 //����
	    			 String newimgname=sp.getSname()+ext;
	    			 //�����ļ�����ָ���ϴ��ļ���·��
	    			 File dostFile=new File(realpath+"/shop/"+newimgname);
	    			 //�ϴ�
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
	     /**********�ļ��ϴ�end************/
	     boolean flag=iBiz.save(sp);
	     if(flag){
	    	 session = request.getSession();
	    	 session.setAttribute("success", "�����Ʒ�ɹ���");
	    	 return "redirect:findAllPage_Shop.do";
	     }
	     session.setAttribute("success", "�����Ʒʧ�ܣ�");
		return "redirect:add.jsp";
	}

	@RequestMapping(value="update_Shop.do")
	public String update(HttpServletRequest request, HttpServletResponse response, Shop sp) {
		//��ȡԭ������Ƭ���ڲ��޸���Ƭ��ʱ��չʾԭ������Ƭ
		String oldimgname=iBiz.findById(sp.getSid()).getImgname();
		 String realpath=request.getRealPath("/");
		  /**********�ļ��ϴ�************/
	     //��ȡ�ϴ���Ƭ����
	     MultipartFile multipartFile=sp.getPic();
	     if(multipartFile!=null&&!multipartFile.isEmpty()){
	    	 //��ȡ�ϴ��ļ�����
	    	 String imgname=multipartFile.getOriginalFilename();
	    	 //����
	    	 if(imgname.lastIndexOf(".")!=-1){
	    		 //��ȡ��׺
	    		 String ext=imgname.substring(imgname.lastIndexOf("."));
	    		 //�жϺ�׺��ʽ
	    		 if(ext.equalsIgnoreCase(".jpg")||ext.equalsIgnoreCase(".png")){
	    			 //����
	    			 String newimgname=sp.getSname()+ext;
	    			 //�����ļ�����ָ���ϴ��ļ���·��
	    			 File dostFile=new File(realpath+"/shop/"+newimgname);
	    			 //�ϴ�
	    			 try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
						 System.out.println("�ļ��ϴ��ɹ�");
						  sp.setImgname(newimgname);
						 //ɾ��ԭ������Ƭ����ȡԭ�����ļ�����
						 File oldfile=new File(realpath+"/shop/"+oldimgname);
						 if(oldfile.exists()&&!oldfile.equals("default.jpg")){
							 oldfile.delete();//ɾ��ԭ����
						 }
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		 }
	    	 }
	     }else{
	    	 //û���ļ��ϴ�
	    	 sp.setImgname(oldimgname);
	     }
	     /**********�ļ��ϴ�end************/
	     boolean flag=iBiz.update(sp);
	     if(flag){
	    	 return "redirect:findAllPage_Shop.do";
	     }
	     
		return "redirect:add.jsp";
	}

	@RequestMapping(value="delById_Shop.do")
	public String delById(HttpServletRequest request, HttpServletResponse response, String sid) {
		//��ȡԭ������Ƭ���ڲ��޸���Ƭ��ʱ��չʾԭ������Ƭ
		String oldimgname=iBiz.findById(sid).getImgname();
		 String realpath=request.getRealPath("/");
		 boolean flag=iBiz.delById(sid);
		 if(flag){
			 //ɾ����Ƭ
			 File oldfile=new File(realpath+"/SHOP/"+oldimgname);
			 if(oldfile.exists()&&!oldfile.equals("default.jpg")){
				 oldfile.delete();//ɾ��ԭ����
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
		//��session�л�ȡpb����
		PageBean pb=(PageBean)session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		page=page==null || page<1?pb.getPage():page;
		rows=rows==null || rows<1?pb.getRows():rows;
		if(page<1)page=1;
		if(rows<1)rows=5;
		//��ȡ��ҳ��
		int maxpage=iBiz.findMaxPage(rows);
		if(page>maxpage)page=maxpage;
		//��ȡ��ǰҳ��¼����
		List<Shop> list=iBiz.findAllPage(page, rows);
		//����ҳ���ݷ�װpb����
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
