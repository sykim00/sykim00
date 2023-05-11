package com.lec.ch19.service;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}
	@Override
	public int joinMember(final Member member, HttpSession session) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "	<div style=\"width:500px; margin:0 auto;\">\r\n" + 
					"		<h1>"+ member.getMname() + "님의 회원가입 감사합니다.</h1>\r\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다.</p>\r\n" + 
					"		<img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\" alt=\"daum로고\">\r\n" + 
					"		<hr color=\"red\">\r\n" + 
					"		<span style=\"color:red;\">빨간 글씨 부분</span><br>\r\n" + 
					"		<span style=\"color:blue;\">파란 글씨 부분</span>\r\n" + 
					"		<p><img src=\"http://localhost:8090/ch19_sch/img/coupon.jpg\" alt=\"쿠폰\"></p>\r\n" + 
					"		<p align=\"center\">서울시 어떤구 몰라 17길 51 어떤빌딩 4층</p>\r\n" + 
					"	</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 받을 메일 설정
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
				// 보낼 메일 
				//mimeMessage.setFrom(new InternetAddress("tiffany789456@gmail.com")); -> 에러날 경우에
				// 메일 제목
				mimeMessage.setSubject("[HTML 가입인사]" + member.getMname() + "님 회원가입 감사합니다.");
				// 메일 본문
				mimeMessage.setText(content, "utf-8", "html");
			}
		}; // message 객체 생성
		mailSender.send(message); // 메일 전송
		session.setAttribute("mid", member.getMid());
		return memberDao.joinMember(member);
	}
	@Override
	public String loginCheck(String mid, String mpw, HttpSession session) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if(member==null) {
			result =  "유효하지 않은 아이디입니다.";
		}else if(!member.getMpw().equals(mpw)) {
			result = "비밀번호가 맞지 않습니다.";
		}else {
			session.setAttribute("member", member);
		}
		return result;
	}
	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}
	@Override
	public int modifyMember(Member member, HttpSession session) {
		session.setAttribute("member", member);
		return memberDao.modifyMember(member);
	}
}
