package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet({ "/Vd3Servlet", "/loai-sua.html" })
public class Vd3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Vd3Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'/>");
		out.println("<title</title>");
		out.println("</head>");
		out.println("<body style='text-align:center'>");
		out.println("<caption>DANH SÁCH LOẠI SỮA</caption>");
		out.println("<table border=1 style=' border: 1px solid black;\r\n"
				+ "  border-collapse: collapse;'>\r\n"
				+ "  <tr>\r\n"
				+ "    <th>Mã loại</th>\r\n"
				+ "    <th>Tên loại</th>\r\n"
				+ "  </tr>");
		
		try {
			String sql = "select * from loai_sua";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbansua?useUsenicode=true&characterEncoding=UTF-8";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString("Ma_loai_sua")+"</td>");
				out.println("<td>"+rs.getString("ten_loai")+"</td>");
				out.println("</tr>");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
