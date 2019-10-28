package kr.magasin.member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet(name = "SendEmail", urlPatterns = { "/sendEmail" })
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    //이메일로 비밀번호 인증번호 보내기.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props = System.getProperties();
		props.put("mail.smtp.user", "hiyomama12"); //서버 아이디만 쓰기

		props.put("mail.smtp.host", "smtp.gmail.com"); //구글 SMTP
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Authenticator auth = new MyAuthentication();
		
		//session 생성 및 MimeMessage 생성
		Session session = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		
		try {
			//편지보낸시간
			msg.setSentDate(new Date());

			InternetAddress from = new InternetAddress("hiyomama12@gmail.com");//보내는사람

			
			//이메일 발신자
			msg.setFrom(from);
			//이메일 수신자
			String email = request.getParameter("email"); //사용자가 입력한 이메일 받아오기
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			
			//이메일 제목
			msg.setSubject("[MAGASIN] 인증번호입니다.","UTF-8");
			
			//이메일 내용
			String code = request.getParameter("code_check"); //인증번호 값 받기
			request.setAttribute("code", code); //인증번호 저장
			msg.setText(code, "UTF-8");
			
			//이메일 헤더
			msg.setHeader("content-Type", "text/html;charset=UTF-8");
			
			//메일 보내기
			javax.mail.Transport.send(msg);
			System.out.println("보냄!");
			
		}catch (AddressException addr_e) {
			addr_e.printStackTrace();
		}catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/join/checkcode.jsp"); //인증번호 확인하는 페이지
		rd.forward(request, response);
	}
	
	class MyAuthentication extends Authenticator{
		PasswordAuthentication pa;
		public MyAuthentication() {
			String id="hiyomama12@gmail.com"; //구글 ID
			String pw="topp0112*"; //구글 비밀번호	

			//ID와 비밀번호를 입력한다.
			pa = new PasswordAuthentication(id,pw);
		}
		public PasswordAuthentication getPasswordAuthentication() {
			return pa;
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
