package redhot.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redhot.bean.StockBean;
import redhot.dao.BookManageDAO;
import redhot.dao.DAOException;
import redhot.dao.PreorderDAO;

/**
 * Servlet implementation class BookManageServlet
 */
@WebServlet("/BookManageServlet")
public class BookManageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			request.setCharacterEncoding("UTF-8");
			// パラメータ解析
			String action = request.getParameter("action");
			BookManageDAO dao = new BookManageDAO();

			// 検索のとき
			if (action.equals("search")) {
				//			int id = Integer.parseInt(request.getParameter("id"));
				String isbn = request.getParameter("isbn");
				//			String name = request.getParameter("name");
				//			int classId = Integer.parseInt(request.getParameter("classId"));
				//			String author = request.getParameter("author");
				//			String publisher = request.getParameter("publisher");
				//			java.sql.Date releaseDate = Integer.parseInt(request.getParameter("releaseDate");
				// とりあえずISBN番号のみの検索に対応
				List<StockBean> list = dao.searchBook(isbn);
				// リストをリクエストスコープに入れてjspへフォワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/book/searchResults.jsp");

				// 追加のとき
			} else if (action.equals("add")) {

				// 	削除のとき
			} else if (action.equals("delete")) {

				// 変更のとき
			} else if (action.equals("update")) {

				// 予約のとき
			} else if (action.equals("preorder")) {
				PreorderDAO preorderDao = new PreorderDAO();
				int stockId = Integer.parseInt(request.getParameter("stockId"));
				int userId = (int) session.getAttribute("id");

				int newPreorderNum = preorderDao.addPreorderQueue(stockId, userId);
				if (newPreorderNum == 1) {
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

		////		List<BookBean> list = dao.findAll();

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
