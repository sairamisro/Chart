package net.javaguides.login.database;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("------>1");
		try {
			List<Barchart> list = loginDao.getBarcharts();
			System.out.println("list : "+list);
			JSONArray array = new JSONArray(list);
			System.out.println("------>2");
			response.setContentType("application/json");
			response.getWriter().write(array.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}