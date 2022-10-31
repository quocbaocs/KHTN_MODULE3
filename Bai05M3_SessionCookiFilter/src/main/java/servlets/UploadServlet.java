package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns = {"/UploadServlet","/upload-file.html"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadServlet() {
        super();
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("upload-File.jsp");
    }
   
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("tapTin");
		
		String tenTapTin = part.getSubmittedFileName();
		String thuMucTaiLen = getServletContext().getRealPath("/uploads/"); //Thư mục thực sự tải lên trên web server
		//C:\\Users\\hv\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebsiteMilk
		InputStream is = part.getInputStream();
		OutputStream os = new FileOutputStream(thuMucTaiLen + tenTapTin);
		System.out.println(tenTapTin);
	//Đọc nhanh hơn
		int len =0;
		byte[] mb = new byte[1024];
		
		//len so lon nhat cua byte duoc doc
		while((len=is.read(mb,0,1024))>0) 
			os.write(mb,0,len);
		
		is.close();
		os.close();
//	response.sendRedirect("upload-File.jsp");
	
	}
    
    
	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("tapTin");
		
		String tenTapTin = part.getSubmittedFileName();
		String thuMucTaiLen = getServletContext().getRealPath("/uploads/"); //Thư mục thực sự tải lên trên web server
		//C:\\Users\\hv\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebsiteMilk
		InputStream is = part.getInputStream();
		OutputStream os = new FileOutputStream(thuMucTaiLen + tenTapTin);
		System.out.println(tenTapTin);
		//Đọc từng byte ghi từng byte rồi tải lên thư mục
		int b;
		while((b=is.read())!=-1) 
			os.write(b);
			
		is.close();
		os.close();
//	response.sendRedirect("upload-File.jsp");
		request.setAttribute("tenTapTin", tenTapTin);
		request.getRequestDispatcher("upload-File.jsp").forward(request, response);
	
	}

}
