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
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("Login");
			return;
		}
		String id = request.getParameter("id");

		UserDao userDao = new UserDao();
		User user = userDao.findById(id);
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("updateId");
		String password = request.getParameter("updatePassword");
		String pCheck = request.getParameter("updatePasswordCheck");
		String name = request.getParameter("updateName");
		String birth_date = request.getParameter("updateBirthDate");
		String login_id = request.getParameter("loginId");
		int iId = Integer.parseInt(id);

		System.out.println(id);
		System.out.println(password);
		System.out.println(pCheck);
		System.out.println(name);
		System.out.println(birth_date);

		UserDao userDao = new UserDao();

		if(name != "" & birth_date != "") {

			if(password == "") {
				boolean update = userDao.userUpdateNmBd(id,name,birth_date);

				if(!update) {
					request.setAttribute("errMsg", "更新に失敗しました。");
					User user = new User(iId, login_id, name, birth_date);
					request.setAttribute("user",user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
					dispatcher.forward(request, response);
				}else {
					response.sendRedirect("UserList");
				}

			}else {
				boolean update = userDao.userUpdate(id,password,pCheck,name,birth_date);

				if(!update) {
					request.setAttribute("errMsg", "更新に失敗しました。");
					User user = new User(iId, login_id, name, birth_date);
					request.setAttribute("user",user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
					dispatcher.forward(request, response);
				}else {
					response.sendRedirect("UserList");
				}

			}
		}else {
			request.setAttribute("errMsg", "更新に失敗しました。");
			User user = new User(iId, login_id, name, birth_date);
			request.setAttribute("user",user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
		}


	}

}
