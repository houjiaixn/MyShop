package com.po;

import java.io.Serializable;

public class Users implements Serializable {
	private String uid;
	private String uname;
	private String upassword;
	private String queshion;
	private String answer;

	public Users() {
		super();
	}

	public Users(String uid, String uname, String upassword, String queshion, String answer) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.queshion = queshion;
		this.answer = answer;
	}

	public Users(String uname, String upassword, String queshion, String answer) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.queshion = queshion;
		this.answer = answer;
	}

	public Users(String uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getQueshion() {
		return queshion;
	}

	public void setQueshion(String queshion) {
		this.queshion = queshion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
