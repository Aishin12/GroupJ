package dto;

public class UserAccount {
	private int userid;
	private String last;
	private String first;
	private String name;
	private int year;
	private int month;
	private int day;
	private String birth;
	private int gender;
	private String email;
	private String pw;
	private String salt;
	private String hashedPw;
	public UserAccount(int userid, String last, String first, String name, int year, int month, int day, String birth,
			int gender, String email, String pw, String salt, String hashedPw) {
		super();
		this.userid = userid;
		this.last = last;
		this.first = first;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.pw = pw;
		this.salt = salt;
		this.hashedPw = hashedPw;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHashedPw() {
		return hashedPw;
	}
	public void setHashedPw(String hashedPw) {
		this.hashedPw = hashedPw;
	}
	
}

