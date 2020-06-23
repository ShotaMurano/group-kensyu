package redhot.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redhot.bean.StockBean;
import redhot.dao.BookManageDAO;
import redhot.dao.DAOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータ解析
			String action = request.getParameter("action");
			BookManageDAO dao = new BookManageDAO();

			// 検索のとき
			if (action.equals("search")) {
				//			int id = Integer.parseInt(request.getParameter("id"));
				int isbn = Integer.parseInt(request.getParameter("isbn"));
				//			String name = request.getParameter("name");
				//			int classId = Integer.parseInt(request.getParameter("classId"));
				//			String author = request.getParameter("author");
				//			String publisher = request.getParameter("publisher");
				//			java.sql.Date releaseDate = Integer.parseInt(request.getParameter("releaseDate");
				// とりあえずISBN番号のみの検索に対応
				List<StockBean> list = dao.searchBook(isbn);
				// リストをリクエストスコープに入れてjspへフォワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/searchResults.jsp");




			// 追加のとき
			} else if (action.equals("add")) {

			// 	削除のとき
			} else if (action.equals("delete")) {

			// 変更のとき
			} else if (action.equals("update")) {

			// 予約のとき
			} else if (action.equals("preorder")) {


			// actionの値がdoPostになければdoGetに投げる
			}else {
				doGet(request, response);
			}
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		////		List<BookBean> list = dao.findAll();

	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}


