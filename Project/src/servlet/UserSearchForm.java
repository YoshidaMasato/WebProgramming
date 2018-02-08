package servlet;

import java.io.Serializable;

public class UserSearchForm extends SearchFormBase implements Serializable {

	private String login_id;
	private String name;
	private String birth_date1;
	private String birth_date2;


	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_date1() {
		return birth_date1;
	}
	public void setBirth_date1(String birth_date1) {
		this.birth_date1 = birth_date1;
	}
	public String getBirth_date2() {
		return birth_date2;
	}
	public void setBirth_date2(String birth_date2) {
		this.birth_date2 = birth_date2;
	}



}
