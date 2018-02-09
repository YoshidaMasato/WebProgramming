package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") != null) {
			response.sendRedirect("UserList");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォームに入力された値を変数に代入
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		//パスワードを暗号化
		String passMD5 = Util.convertToMD5(password);

		System.out.println(loginId);
		System.out.println(passMD5);

		//入力された値を元にDBでユーザ検索し、ユーザ情報を引き出す
		UserDao userDao = new UserDao();
		User user = userDao.findByLoginId(loginId,passMD5);

		if(user == null) {
			//Daoからnullが帰ってきたらログイン失敗
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		}else {
			//ユーザ情報をセッションスコープにセットしてユーザ一覧にリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			response.sendRedirect("UserList");

		}
	}

}
