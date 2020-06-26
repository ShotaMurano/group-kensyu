package redhot.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redhot.bean.MemberBean;
import redhot.dao.DAOException;
import redhot.dao.MemberDAO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");

			MemberDAO dao = new MemberDAO();
			if (action.contentEquals("addResults")) {
				String lastName = request.getParameter("lastName");
				String firstName = request.getParameter("firstName");
				String address = request.getParameter("address");
				String tellphone = request.getParameter("tellphone");
				Date birthday = Date.valueOf(request.getParameter("birthday"));
				String mailAddress = request.getParameter("mailAddress");

				dao.addMember(lastName, firstName, address, tellphone, birthday, mailAddress);
				List<MemberBean> list = dao.findAll();
				request.setAttribute("add", list);
				gotoPage(request, response, "/member/addResults.jsp");
			} else if (action.contentEquals("add")) {
				gotoPage(request, response, "/member/addMember.jsp");
			} else if (action.contentEquals("search")) {
				String id = request.getParameter("id");
				String lastName = request.getParameter("lastName");
				String firstName = request.getParameter("firstName");
				String address = request.getParameter("address");
				String tellphone = request.getParameter("tellphone");
				String birthday = request.getParameter("birthday");
				String mailAddress = request.getParameter("mail_Address");

				//"1"なら現会員、"2なら退会済"
				String isOut = request.getParameter("inout");

				List<MemberBean> list = dao.searchMember(id, lastName, firstName, address, tellphone, birthday,
						mailAddress, isOut);
				request.setAttribute("members", list);
				//				if (isOut.contentEquals("2")) {
				//					gotoPage(request, response, "/member/searchResultsOut.jsp");
				//				} else if (isOut.contentEquals("1")) {
				//					gotoPage(request, response, "/member/searchResultsIn.jsp");
				//				} else if (isOut.contentEquals("")) {
				//					gotoPage(request, response, "/member/searchResultsIn.jsp");
				//				}
				switch (isOut) {
				case "1":
					gotoPage(request, response, "/member/searchResultsIn.jsp");
					break;
				case "2":
					gotoPage(request, response, "/member/searchResultsOut.jsp");
					break;
				default:
					gotoPage(request, response, "/member/searchResultsIn.jsp");
				}
			} else if (action.contentEquals("updateResults")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String lastName = request.getParameter("lastName");
				String firstName = request.getParameter("firstName");
				String address = request.getParameter("address");
				String tellphone = request.getParameter("tellphone");
				Date birthday = Date.valueOf(request.getParameter("birthday"));
				String mailAddress = request.getParameter("mailAddress");
				Date outDate = null;
				if (request.getParameter("outDate") != "") {
					outDate = Date.valueOf(request.getParameter("outDate"));
				}

				dao.updateMember(id, lastName, firstName, address, tellphone, birthday, mailAddress, outDate);
				List<MemberBean> list = dao.findAll();
				request.setAttribute("updates", list);
				gotoPage(request, response, "/member/updateResults.jsp");

			} else if (action.contentEquals("update")) {
				gotoPage(request, response, "/member/updateForm.jsp");
			} else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errInternal.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
