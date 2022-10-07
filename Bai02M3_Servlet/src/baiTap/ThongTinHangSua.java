package baiTap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThongTinHangSua
 */
@WebServlet({ "/ThongTinHangSua", "/thong-tin-hang-sua.html" })
public class ThongTinHangSua extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn;
   
    public ThongTinHangSua() {
        super();
       
    }
    @Override
    	public void init() throws ServletException {
    	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbansua?useUsenicode=true&characterEncoding=UTF-8";
			String user = "root";
			String password = "quocbao@123";
			 conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from hang_sua";
		Statement stm;
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'/>");
		out.println("<title>Ví dụ 2</title>");
		out.println("<style>table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n"
				+ "}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style='text-align: center;"
				+ "  border: 1px solid;'");
		out.println("<h1><b>THÔNG TIN HÃNG SỮA</b></h1>");
		out.println("<table style=' margin: 0 auto; border: 1px solid black;'>");
		out.println("<tr>");
		out.println("<td>Mã HS</td>");
		out.println("<td>Tên hãng sữa</td>");
		out.println("<td>Địa chỉ</td>");
		out.println("<td>Điện thoại</td>");
		out.println("<td>Email</td>");
		out.println("</tr>");
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
			
			out.println("<tr>");
			
			out.println("<td>"+rs.getString("Ma_hang_sua")+"</td>");
			out.println("<td>"+rs.getString("Ten_hang_sua")+"</td>");
			out.println("<td>"+rs.getString("Dia_chi")+"</td>");
			out.println("<td>"+rs.getString("Dien_thoai")+"</td>");
			out.println("<td>"+rs.getString("Email")+"</td>");
			out.println("</tr>");
			
		
				
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
