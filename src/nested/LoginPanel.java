package nested;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginPanel extends Panel {
	private Label idL, pwdL;
	private TextField idT, pwdT;
	private Button loginBtn, resetBtn;
	
	public LoginPanel() {
		this.setBackground(Color.GREEN);
		setLayout(null);
		
		//생성
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("로그인");
		resetBtn = new Button("다시 작성");
		
		//글꼴 크기
		Font labelF = new Font("맑은고딕", 1, 15);
		Font textF = new Font("맑은고딕", 1, 25);
		
		idL.setFont(labelF);
		idT.setFont(textF);
		pwdL.setFont(labelF);
		pwdT.setFont(textF);
		loginBtn.setFont(labelF);
		resetBtn.setFont(labelF);
		
		//배치
		idL.setBounds(20, 100, 70, 30);
		idT.setBounds(20, 130, 450, 50);
		
		pwdL.setBounds(20, 190, 70, 30);
		pwdT.setBounds(20, 220, 450, 50);
		
		loginBtn.setBounds(20, 330, 220, 50);
		resetBtn.setBounds(250, 330, 220, 50);
		
		this.add(idL);
		this.add(idT);
		this.add(pwdL);
		this.add(pwdT);
		this.add(loginBtn);
		this.add(resetBtn);
		
		//이벤트
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//데이터
				String id = idT.getText();
				String pwd = pwdT.getText();
				
				//DB
				MemberDAO dao = new MemberDAO();
				String name = dao.loginMember(id, pwd);
				
				if(name == null) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.");
				}else {
					JOptionPane.showMessageDialog(null, name + "님 로그인");
				}
				
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idT.setText("");
				pwdT.setText("");
			}
		});
	}
}










