package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;

public class BookDAO {
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
		public static int deleteTosyo(int isbn) {
			
			String sql = "DELETE FROM book WHERE isbn = ?";
			int result = 0;
			
			try (
					Connection con =getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setInt(1, isbn);

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件削除しました。");
			}
			return result;
		}
		//SELECT * FROM book WHERE title like '' OR kana_title like 'ハシレメロス' OR author like '';
		public static List<BookDTO> selectBook(String keyword){
			
			// 実行するSQL
			String sql = "SELECT * FROM book WHERE title like ? OR kana_title like ? OR author like ?";
			List<BookDTO> result=new ArrayList<>();
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setString(1, "%"+ keyword +"%");
				pstmt.setString(2, "%"+ keyword +"%");
				pstmt.setString(3, "%"+ keyword +"%");
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					while(rs.next()) {
					
						int bookid = rs.getInt("bookid");
						String title = rs.getString("title");
						String kana_title = rs.getString("kana_title");
						String author = rs.getString("author");
						int isbn = rs.getInt("isbn");
						String publisher = rs.getString("publisher");
						String publication_date = rs.getString("publication_date");
						String rental = rs.getString("rental");
						// n件目のインスタンスを作成
						BookDTO searchresult = new BookDTO(bookid,title, kana_title, author, isbn, publisher, publication_date,rental);
						
						
						result.add(searchresult);
					}
				}
				
			} catch (SQLException e) {                                                                                            
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			return result;
		}	
public static List<BookDTO> deleteselectBook(int isbn){
			
			// 実行するSQL
			String sql = "SELECT * FROM book WHERE isbn = ?";
			List<BookDTO> result=new ArrayList<>();
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setInt(1, isbn);
				
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					while(rs.next()) {
					
						int bookid = rs.getInt("bookid");
						String title = rs.getString("title");
						String kana_title = rs.getString("kana_title");
						String author = rs.getString("author");
						
						String publisher = rs.getString("publisher");
						String publication_date = rs.getString("publication_date");
						String rental = rs.getString("rental");						// n件目のインスタンスを作成
						BookDTO searchresult = new BookDTO(bookid,title, kana_title, author,isbn, publisher, publication_date,rental);
						
						
						result.add(searchresult);
					}
				}
				
			} catch (SQLException e) {                                                                                            
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			return result;
		}	

		// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
		public static int registerBook(BookDTO BookDTO) {

			String sql = "INSERT INTO book VALUES(default,?,?,?,?,?,?,false)";

			int result = 0;
			
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				pstmt.setString(1, BookDTO.getTitle());
				pstmt.setString(2, BookDTO.getKana_title());
				pstmt.setString(3, BookDTO.getAuthor());	
				pstmt.setInt(4, BookDTO.getIsbn());
				pstmt.setString(5,BookDTO.getPublisher());
				pstmt.setString(6, BookDTO.getPublication_date());
				


				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
				
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
}
		
		public static int deleteBook(int bookid) {
			
			String sql = "DELETE FROM book WHERE bookid = ?";
			int result = 0;
			
			try (
					Connection con =getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setInt(1, bookid);

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件削除しました。");
			}
			return result;
		}
		
		public static int updateBook(BookDTO BookDTO) {

			String sql = "UPDATE  book SET title = ? WHERE bookid = ?";

			int result = 0;
			
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				pstmt.setString(1, BookDTO.getTitle());
				pstmt.setString(2, BookDTO.getKana_title());
				pstmt.setString(3, BookDTO.getAuthor());	
				pstmt.setInt(4, BookDTO.getIsbn());
				pstmt.setString(5,BookDTO.getPublisher());
				pstmt.setString(6, BookDTO.getPublication_date());
				


				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
				
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
}
	
		
public static List<BookDTO> selectupdateBook(String title){
			
			// 実行するSQL
			String sql = "SELECT * FROM book WHERE title like ?";
			List<BookDTO> result=new ArrayList<>();
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setString(1, "%"+ title +"%");
			
				
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					while(rs.next()) {
					
						int bookid = rs.getInt("bookid");
				
						String kana_title = rs.getString("kana_title");
						String author = rs.getString("author");
						int isbn = rs.getInt("isbn");
						String publisher = rs.getString("publisher");
						String publication_date = rs.getString("publication_date");
						String rental = rs.getString("rental");
						// n件目のインスタンスを作成
						BookDTO searchresult = new BookDTO(bookid,title, kana_title, author, isbn, publisher, publication_date,rental);
						
						
						result.add(searchresult);
					}
				}
				
			} catch (SQLException e) {                                                                                            
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			return result;
		}	
		
}
