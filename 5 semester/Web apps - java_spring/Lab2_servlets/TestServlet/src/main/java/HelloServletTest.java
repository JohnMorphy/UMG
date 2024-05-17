

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Servlet implementation class HelloServletTest
 */
public class HelloServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] colors = {"black", "yellow", "green", "blue", "red"};
		Random random = new Random();
		String color = colors[random.nextInt(colors.length)];
		
		response.setContentType("text/html; charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();
		 String s="<!DOCTYPE html>\n"
		 +"<html lang=\"pl\">\n"
		 +"<head>\n"
		 +"<style>h1 {background-color:" + color + ";}</style>\n"
		 +"</head>\n<body>\n"
		 + "<h1>Hello Servlet!</h1>\n"
		 + "<p>Mój pierwszy servlet.</p>\n"
		 + "<p>W pierwszej aplikacji Web Java</p>\n"
		 + "</body>\n</html>";
		 printWriter.println(s);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
