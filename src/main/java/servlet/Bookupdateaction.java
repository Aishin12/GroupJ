package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDTO;

/**
 * Servlet implementation class Bookupdateaction
 */
@WebServlet("/Bookupdateaction")
public class Bookupdateaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookupdateaction() {
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
	
		 String view ="WEB-INF/view/bookregistercomfirm.jsp";
		  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		  dispatcher.forward(request, response);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
