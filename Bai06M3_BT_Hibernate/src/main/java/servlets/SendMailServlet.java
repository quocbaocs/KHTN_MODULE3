package servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendmail.do")
public class SendMailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("views/mail/mail.jsp").forward(request, response);
	}

	private static boolean send(String to, String subject, String text) {
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.user", "quocbaole368@gmail.com");
			props.setProperty("mail.smtp.password", "quocbao@1234");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("quocbaole368@gmail.com", "yytcalppkpbjunpi");
				}
			});
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("quocbaole368@gmail.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(text);
			Transport.send(msg);
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String msg = "Failed";
		String name = request.getParameter("txt_name");
		String phone = request.getParameter("txt_phone");
		String content = request.getParameter("txt_message");
		StringBuilder builder = new StringBuilder();
		builder.append("Họ và tên: "+name.toUpperCase()+"\n");
		builder.append("Điện thoại: "+phone+"\n");
		builder.append(content);
		if (send(request.getParameter("email"), request.getParameter("subject"), builder.toString())) {
			msg = "Gửi mail thành công";
		}
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}