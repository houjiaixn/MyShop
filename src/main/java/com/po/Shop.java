package com.po;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class Shop implements Serializable {
	private String sid; // 商品编号
	private String sname; // 商品名称
	private String price; // 商品价格
	private String num; // 商品数量
	private String acount; // 每条记录的总金额
	private String imgname = "default.jpg"; // 商品图片
	private String userid;
	private String uname;
	//Spring的文件上传
	private MultipartFile pic;

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(String sid, String sname, String price, String num, String acount, String userid, String uname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.num = num;
		this.acount = acount;
		this.userid = userid;
		this.uname = uname;
	}

	public Shop(String sid, String sname, String price, String num, String userid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.num = num;
		this.userid = userid;
	}

	public Shop(String sid, String sname, String price, String num, String acount, String imgname, String userid,
			String uname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.num = num;
		this.acount = acount;
		this.imgname = imgname;
		this.userid = userid;
		this.uname = uname;
	}

	public Shop(String sid, String sname, String price, String num, String acount, String uname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.num = num;
		this.acount = acount;
		this.uname = uname;
	}

	// 特定
	public Shop(String sname, String price, String num) {
		super();
		this.sname = sname;
		this.price = price;
		this.num = num;
	}
	
	public Shop(String sid, String sname, String price, String num, String acount, String imgname, String userid,
			String uname, MultipartFile pic) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.num = num;
		this.acount = acount;
		this.imgname = imgname;
		this.userid = userid;
		this.uname = uname;
		this.pic = pic;
	}

	public String getAcount() {
		acount = Integer.parseInt(price) * Integer.parseInt(num) + "";
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUname() {
		return uname;
	}

	public void setUsername(String uname) {
		this.uname = uname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
}
