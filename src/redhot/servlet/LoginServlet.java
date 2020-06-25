package redhot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redhot.dao.DAOException;
import redhot.dao.MemberDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {

			PrintWriter out = response.getWriter();

			String action = request.getParameter("action");
			MemberDAO dao = new MemberDAO();
			if (action.contentEquals("login")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String password = request.getParameter("password");
				if (dao.checkLogin(id, password) == true) {
					HttpSession session = request.getSession();
					session.setAttribute("isLogin", true);
					session.setAttribute("id", id);
					//					out.println("<html><head><title>Login</title></head><body>");
					//					out.println("<h3>ログイン成功<h3>");
					//					out.println("</body></html>");
					gotoPage(request, response, "/topPage.jsp");
				} else {
					out.println("<html><head><title>Login</title></head><body>");
					out.println("<h3>ユーザ名またはパスワードが違います<h3>");
					out.println("</body></html>");

				}
			} else if (action.contentEquals("logout")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
					out.println("<html><head><title>Login</title></head><body>");
					out.println("<h3>ログアウトしました<h3>");
					out.println("</body></html>");
				}

			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
