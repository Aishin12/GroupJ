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
import util.GenerateHashedPw;
import util.GenerateSalt;

/**
 * Servlet implementation class User_AccountPassResetExecuteServlet
 */
@WebServlet("/User_AccountPassResetExecuteServlet")
public class User_AccountPassResetExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_AccountPassResetExecuteServlet() {
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
		
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		UserAccount account = (UserAccount)session.getAttribute("user_lostPw");
		
		int userid = account.getUserid();
		String name = account.getName();
		String birth = account.getBirth();
		int gender = account.getGender();
		String mail = account.getMail();
		
		
		String salt = GenerateSalt.getSalt(32);
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw,salt);
		
		UserAccount UdAccount = new UserAccount(userid,name,birth,gender,mail,salt,hashedPw);
		
		int result = User_AccountDAO.pwUpdate(UdAccount);
		System.out.println("resultの値："+result);
		
		String path = "";
		
		session.removeAttribute("user_lostPw");
		
		if(result == 1) {	

			session.setAttribute("user", UdAccount);
			path = "WEB-INF/view/User_AccountPassResetSuccess.jsp";
		
		} else {
			// 失敗した場合はパラメータ付きで登録画面に戻す
			path = "WEB-INF/view/User_AccountPassResetFailed.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
