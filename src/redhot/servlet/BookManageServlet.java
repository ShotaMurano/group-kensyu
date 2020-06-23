package redhot.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redhot.dao.BookManageDAO;
import redhot.dao.DAOException;
import redhot.dao.PreorderDAO;
import redhot.tool.UniversalTool;

/**
 * Servlet implementation class BookManageServlet
 */
@WebServlet("/BookManageServlet")
public class BookManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			HttpSession session = request.getSession(false);

			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");

			BookManageDAO bookDao = new BookManageDAO();
			PreorderDAO preorderDao = new PreorderDAO();
			if (action.contentEquals("preorder")) {
				int userId = (int) session.getAttribute("id");
				int stockId = Integer.parseInt(request.getParameter("stockId"));
				if (UniversalTool.isUserUsable(borrowNum, preorderNum)) {
					//preorderDao.addPreorderQueue(stockId, userId);
					int newPreorderNum = preorderDao.addPreorderQueue(1, 1);
					gotoPage(request, response, "/preorder/finishedPreorder.jsp");
				} else {
					request.setAttribute("message", "資料の貸し出し、予約の合計は5冊までです。");
					gotoPage(request, response, "/errInternal.jsp");
				}
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Exceptionを作ったらここでtry&catchする
		BookManageDAO dao = new BookManageDAO();
		//		List<BookBean> list = dao.findAll();

		doGet(request, response);
	}

}
