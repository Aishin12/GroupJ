package dto;

public class UserAccount {
	private int userid;
	private String name;
	private String birth;
	private int gender;
	private String mail;
	private String salt;
	private String pw;
	public UserAccount(int userid, String name, String birth, int gender, String mail, String salt, String pw) {
		super();
		this.userid = userid;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.salt = salt;
		this.pw = pw;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}

