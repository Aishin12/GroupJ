package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BookDTO;

/**
 * Servlet implementation class BookregisteractionServlet
 */
@WebServlet("/BookregisteractionServlet")
public class BookregisteractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookregisteractionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//  フォーム入力内容の取得
		String title = request.getParameter("title");
		String kana_title = request.getParameter("kana_title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String publisher = request.getParameter("publisher");
		String publication_date = request.getParameter("publication_date");
		
		
		int ISBN= Integer.parseInt(isbn);
		
		
		String rental = "";
		int id = 0;
		// 入力された情報を元にインスタンスを生成
		BookDTO book = new BookDTO(id,title,kana_title,author,ISBN,publisher,publication_date,rental);
	
		
		HttpSession session = request.getSession();
		
		// セッションスコープに値の保存
		// 第1引数：キー
		// 第2引数：保存する値
		session.setAttribute("input_data", book);
		
		  String view ="WEB-INF/view/bookregistercomfirm.jsp";
		  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		  dispatcher.forward(request, response);
		
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
