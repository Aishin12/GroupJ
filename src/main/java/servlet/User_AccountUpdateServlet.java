package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User_AccountDAO;
import dto.UserAccount;

/**
 * Servlet implementation class User_AccountUpdateServlet
 */
@WebServlet("/User_AccountUpdateServlet")
public class User_AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_AccountUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String last = request.getParameter("last");
		String first = request.getParameter("first");
		String StrYear = request.getParameter("year");
		String StrMonth = request.getParameter("month");
		String StrDay = request.getParameter("day");
		String StrGender = request.getParameter("gender");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		int gender = Integer.parseInt(StrGender);
		
		String name = last+" "+first;
		String birth = StrYear + StrMonth + StrDay;

		UserAccount user = new UserAccount(-1,name,birth,gender,mail,null,pw);
		
		HttpSession session = request.getSession();
		session.setAttribute("input_user", user);
		
		int result = User_AccountDAO.UpdateUserAccount(user);
		System.out.println("resultの値："+result);
		
		String path = "";
		
		if(result == 1) {			
			path = "WEB-INF/view/User_AccountEditSuccess.jsp";
		} else {
			// 失敗した場合はパラメータ付きで登録画面に戻す
			path = "./";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
	}

}
