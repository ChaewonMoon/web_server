package com.MHE_Project.web;


/*연습용으로 만든 파일이니 신경쓰지 않으셔도 됩니다 */


public class User {
	private String userID;
	private String password;
/*	private String name;
	private String email; */

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
/* 이름과 이메일주소는 쓰지 않으므로 일단 주석처리 함.
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
*/
	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + "]";
	}

}
