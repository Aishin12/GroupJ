package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserAccount;

/**
 * Servlet implementation class User_RegisterComfirmServlet
 */
@WebServlet("/User_RegisterComfirmServlet")
public class User_RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String last = request.getParameter("last");
		String first = request.getParameter("first");
		String StrYear = request.getParameter("year");
		String StrMonth = request.getParameter("month");
		String StrDay = request.getParameter("day");
		String mail = request.getParameter("mail");
		String StrGender = request.getParameter("gender");
		int gender = Integer.parseInt(StrGender);
		String pw = request.getParameter("pw");
		
		String name = last+" "+first;
		String birth = StrYear + StrMonth + StrDay;
		
		UserAccount user = new UserAccount(-1,name,birth,gender,mail,null,pw);
		HttpSession session = request.getSession();
		
		session.setAttribute("input_user", user);
		
		String view = "WEB-INF/view/User_RegisterConfirm.jsp";
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
