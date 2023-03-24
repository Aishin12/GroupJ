package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserAccount;
import dto.UserLoginAccount;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class User_AccountDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int RegisterUserAccount(UserAccount user) {
		String sql = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?, ?, current_timestamp)";
		int result  = 0;
		
		String salt = GenerateSalt.getSalt(32);
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(user.getPw(),salt);

		System.out.println(salt);
		System.out.println(hashedPw);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getBirth());
			pstmt.setInt(3, user.getGender());
			pstmt.setString(4, user.getMail());
			pstmt.setString(5, salt);
			pstmt.setString(6, hashedPw);

			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
		
	}
	

	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM users WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static UserLoginAccount login(String mail, String hashedPw) {
		String sql = "SELECT userid, name, birth, gender, salt  FROM users WHERE mail = ? AND pw = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int userid = rs.getInt("userid");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int gender = rs.getInt("gender");
					String salt = rs.getString("salt");
					
					return new UserLoginAccount(userid,name,birth,gender,mail,salt,hashedPw);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
