package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_AccountDAO;
import util.MailUtil;

/**
 * Servlet implementation class User_ChangePassConfirm
 */
@WebServlet("/User_ChangePassConfirm")
public class User_ChangePassConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_ChangePassConfirm() {
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
		
		String mail1 = request.getParameter("mail1");
		String mail2 = request.getParameter("mail2");
		
		System.out.println(mail1);
		String path = "";
		
		if(mail1.equals(mail2)){
			String name = User_AccountDAO.searchMail(mail1);
			
			System.out.println(name);
			
			if(name == null){
				path ="WEB-INF/view/User_ChangePassForm.jsp?error=1";
				return;
			}
			
			String url = "http://localhost:8080/GroupJ/User_AccountPassResetFormServlet?mail="+mail1;
			
			MailUtil.sendMail(mail1,"盛ジョビ図書館のパスワードの再設定の通知","こんにちは"+name+"さん。盛ジョビ図書館のパスワードの再設定はこちらのリンクから行えます。"+url);
			
			path ="WEB-INF/view/User_ChangePassResult.jsp";
		}else {
			path ="WEB-INF/view/User_ChangePassForm.jsp?error=1";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
