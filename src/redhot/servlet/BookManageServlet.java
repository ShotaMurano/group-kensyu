package redhot.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redhot.bean.BookBean;
import redhot.bean.BorrowBean;
import redhot.bean.MemberBean;
import redhot.bean.StockBean;
import redhot.dao.BookManageDAO;
import redhot.dao.DAOException;
import redhot.dao.MemberDAO;
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
			//会員と管理画面でのIDの使い分けをどうするか
			HttpSession session = request.getSession(false);
			request.setCharacterEncoding("UTF-8");
			// パラメータ解析
			String action = request.getParameter("action");
			BookManageDAO dao = new BookManageDAO();

			// 検索のとき
			if (action.equals("search")) {
				String isbn = request.getParameter("isbn");
				String name = request.getParameter("name");
				String classId = request.getParameter("classId");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String releaseDate = request.getParameter("releaseDate");
				// とりあえずISBN番号のみの検索に対応
				List<StockBean> list = dao.searchBook(isbn, name, classId, author, publisher, releaseDate);
				// リストをリクエストスコープに入れてjspへフォワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/book/searchResults.jsp");
				// 追加のとき
			} else if (action.contentEquals("isbn_search")) {
				String isbn = request.getParameter("isbn");
				BookBean book = dao.searchIsbn(isbn);
				book.setIsbn(isbn);
				request.setAttribute("bookBean", book);
				gotoPage(request, response, "/book/add.jsp");
			} else if (action.contentEquals("checkAdd")) {
				String isbn = request.getParameter("isbn");
				String name = request.getParameter("name");
				int classId = Integer.parseInt(request.getParameter("classId"));
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				Date releaseDate = Date.valueOf(request.getParameter("releaseDate"));
				BookBean bookBean = new BookBean(isbn, name, classId, author, publisher, releaseDate);
				request.setAttribute("bookBean", bookBean);
				gotoPage(request, response, "/book/checkAdd.jsp");
			} else if (action.equals("add")) {
				String isbn = request.getParameter("isbn");
				String name = request.getParameter("name");
				int classId = Integer.parseInt(request.getParameter("classId"));
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				Date releaseDate = Date.valueOf(request.getParameter("releaseDate"));
				BookBean bookBean = new BookBean(isbn, name, classId, author, publisher, releaseDate);
				dao.addBook(bookBean);
				dao.addStock(isbn);

				gotoPage(request, response, "/book/finishedAdd.jsp");

				// 削除、仮確定のとき
			} else if (action.equals("delete_check")) {
				String book_id = request.getParameter("book_id");
				String book_name = request.getParameter("book_name");
				request.setAttribute("book_id", book_id);
				request.setAttribute("book_name", book_name);
				gotoPage(request, response, "/book/delete_check.jsp");
				//削除、確定のとき
			} else if (action.equals("delete")) {
				String book_id = request.getParameter("book_id");
				String message = dao.deleteBook(Integer.parseInt(book_id));
				request.setAttribute("message", message);
				gotoPage(request, response, "/book/delete_confirm.jsp");

				// 変更のとき
			} else if (action.equals("update_check")) {
				String book_isbn = request.getParameter("book_isbn");
				BookBean bookbean = updateBook(book_isbn);
				request.setAttribute("bookinfo", bookbean);
				gotoPage(request, response, "/book/modify_check.jsp");
				//変更確定のとき
			} else if (action.equals("update")) {

				String isbn = request.getParameter("isbn");
				String name = request.getParameter("name");
				String classId = request.getParameter("classId");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String releaseDate = request.getParameter("releaseDate");
				dao.update(isbn, name, classId, author, publisher, releaseDate);
				request.setAttribute("isbn", isbn);
				request.setAttribute("name", name);
				request.setAttribute("classId", classId);
				request.setAttribute("author", author);
				request.setAttribute("publisher", publisher);
				request.setAttribute("releaseDate", releaseDate);
				gotoPage(request, response, "/book/modify_confirm.jsp");
				// 予約のとき
				//まず予約したい会員番号の入力を受ける
			} else if (action.equals("preorderForm")) {
				String book_id = request.getParameter("book_id");
				String book_name = request.getParameter("book_name");
				request.setAttribute("book_id", book_id);
				request.setAttribute("book_name", book_name);
				gotoPage(request, response, "/preorder/preorderForm.jsp");
				//返却された本の検索
			} else if (action.equals("searchReturnedBook")) {
				List<StockBean> list = dao.searchReturnedBook();
				for (StockBean sb : list) {
					sb.setPreorderStatus(dao.searchPreorderStatus(sb.getId()));
				}
				request.setAttribute("returned_books", list);
				gotoPage(request, response, "/book/search_returned_book_results.jsp");

				//本を館内に移動
			} else if (action.equals("exist")) {
				String book_id = request.getParameter("book_id");
				dao.modifyExitBook(Integer.parseInt(book_id));
				List<StockBean> list = dao.searchReturnedBook();
				for (StockBean sb : list) {
					sb.setPreorderStatus(dao.searchPreorderStatus(sb.getId()));
				}
				request.setAttribute("returned_books", list);
				gotoPage(request, response, "/book/search_returned_book_results.jsp");
				//本を予約棚に移動
			} else if (action.equals("keep")) {
				String book_id = request.getParameter("book_id");
				dao.modifyKeepBook(Integer.parseInt(book_id));
				List<StockBean> list = dao.searchReturnedBook();
				for (StockBean sb : list) {
					sb.setPreorderStatus(dao.searchPreorderStatus(sb.getId()));
				}
				request.setAttribute("returned_books", list);
				gotoPage(request, response, "/book/search_returned_book_results.jsp");
				//次に予約の確認画面
			} else if (action.equals("preorderCheck")) {
				String book_id = request.getParameter("book_id");
				String book_name = request.getParameter("book_name");
				String id = request.getParameter("id");
				// 会員IDの入力がなかったらフォーム画面に戻す
				if (id.length() == 0 || id == null) {
					request.setAttribute("message", "会員IDを入力してください");
					gotoPage(request, response, "/preorder/errorPreorderCheck.jsp");
					// 会員IDの入力があるとき
				} else {
					MemberDAO memberDao = new MemberDAO();
					List<MemberBean> list = memberDao.searchMember(id, "", "", "", "", "", "", "");
					MemberBean[] b = new MemberBean[list.size()];
					b[0] = list.get(0);
					// 存在し、退会していない会員のとき次の処理へ進める
					if (list.size() != 0 && b[0].getOutDate() == null) {
						request.setAttribute("book_id", book_id);
						request.setAttribute("book_name", book_name);
						request.setAttribute("id", id);
						gotoPage(request, response, "/preorder/preorderCheck.jsp");
						// 存在しない会員IDまたは退会済み会員IDだったらフォーム画面に戻す
					} else {
						request.setAttribute("message", "存在する退会していない会員のIDを入力してください");
						gotoPage(request, response, "/preorder/errorPreorderCheck.jsp");
					}

				}

				//予約関数を呼んで完了画面の表示
			} else if (action.equals("preorder")) {
				String book_id = request.getParameter("book_id");
				String book_name = request.getParameter("book_name");
				String id = request.getParameter("id");

				PreorderDAO preorderDao = new PreorderDAO();
				//				int stockId = Integer.parseInt(request.getParameter("stockId"));
				//				int userId = (int) session.getAttribute("id");
				int stockId = Integer.parseInt(book_id);
				int userId = Integer.parseInt(id);
				int newPreorderNum = preorderDao.addPreorderQueue(stockId, userId);

				if (newPreorderNum == 1) {
					request.setAttribute("book_id", book_id);
					request.setAttribute("book_name", book_name);
					request.setAttribute("id", id);
					gotoPage(request, response, "/preorder/finishedPreorder.jsp");
				} else {
					request.setAttribute("message", "資料の貸し出し、予約の合計は5冊までです。");
					gotoPage(request, response, "/errInternal.jsp");
				}

				//貸出のとき
			} else if (action.equals("rental")) {
				List<String> book_id = new ArrayList<String>();
				int count = 0;
				for (int i = 0; i < 5; i++) {
					if ("".equals(request.getParameter("book_id_" + (i + 1) + ""))) {
					} else {
						book_id.add(request.getParameter("book_id_" + (i + 1) + ""));
						count++;
					}
				}
				int member_id = Integer.parseInt(request.getParameter("member_id"));
				count += dao.getBorrowNum(member_id);
				count += dao.getPreorderNum(member_id);
				if (count <= 5) {
					List<BorrowBean> list = dao.borrowBook(member_id, book_id);
					request.setAttribute("items", list);
					gotoPage(request, response, "/book/rentalResults.jsp");
				} else {
					request.setAttribute("count", count);
					gotoPage(request, response, "/book/error_rental.jsp");
				}

				// 返却のとき
			} else if (action.equals("return")) {
				List<String> book_id = new ArrayList<String>();
				String status = null; //getBookStatusの返り値を格納する
				for (int i = 0; i < 5; i++) {
					if ("".equals(request.getParameter("book_id_" + (i + 1) + ""))) {
					} else {
						status = dao.getBookStatus(Integer.parseInt(request.getParameter("book_id_" + (i + 1) + "")));
						if ("borrow".equals(status)) {
							book_id.add(request.getParameter("book_id_" + (i + 1) + ""));
						}
					}
				}
				int member_id = Integer.parseInt(request.getParameter("member_id"));
				if (book_id.size() != 0) {
					List<BorrowBean> list = dao.returnBook(member_id, book_id);
					request.setAttribute("items", list);
					gotoPage(request, response, "/book/returnResults.jsp");
				} else {
					gotoPage(request, response, "/book/error_return.jsp");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
		}

		////		List<BookBean> list = dao.findAll();

	}

	private BookBean updateBook(String book_isbn) throws DAOException {
		BookManageDAO dao = new BookManageDAO();
		if (dao.hasisbn(book_isbn) == true) {
			BookBean bookbean = dao.getBookInfo(book_isbn);
			return bookbean;
		} else {
			//			dao.addNewBook(book_isbn);
			return null;
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
