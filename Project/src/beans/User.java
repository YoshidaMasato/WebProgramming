package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int id;
	private String login_id;
	private String name;
	private String birth_date;
	private String password;
	private String create_date;
	private String update_date;

	public User(String login_id,String name) {
		this.login_id = login_id;
		this.name = name;
	}

	public User(int id, String login_id, String name, String birth_date) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
	}

	public User(int id, String login_id, String name, String birth_date, String create_date, String update_date) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public User(String login_id, String name, String birth_date) {
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getBirth_date() {
		return birth_date;
	}
	//yyyy年MM月dd日でフォーマットした生年月日のgetter
	public String getBirth_date_format() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatBirthDate;
		try {
			formatBirthDate = sdf.parse(birth_date);
			String str = new SimpleDateFormat("yyyy年MM月dd日").format(formatBirthDate);
			return str;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}
