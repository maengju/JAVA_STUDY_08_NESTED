package nested;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame-BorderLayout(동서남북), 동서남북 각각에는 1개의 Component가 올라간다
public class MemberMain extends Frame implements ActionListener {
	private Button homeBtn, writeBtn, loginBtn;
	private CardLayout card;
	private Panel centerP;
	
	public MemberMain() {
		homeBtn = new Button("홈");
		writeBtn = new Button("회원가입");
		loginBtn = new Button("로그인");
		
		card = new CardLayout();
		
		//3개의 버튼
		Panel northP = new Panel(); //Panel-FlowLayout(순서배치)
		northP.setBackground(new Color(45, 180, 0));
		northP.add(homeBtn);
		northP.add(writeBtn);
		northP.add(loginBtn);
		
		//카드레이아웃으로 깬 패널 입니다 여기가 계속 바뀔겁니다
		centerP = new Panel();
		centerP.setLayout(card);
		centerP.add("home", new HomePanel());
		centerP.add("write", new WritePanel());
		centerP.add("login", new LoginPanel());
		
		this.add("North", northP);
		this.add("Center", centerP);
		
		this.setBounds(700, 100, 500, 500);
		this.setResizable(false);
		this.setVisible(true);
		
		//이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//버튼 이벤트
		homeBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homeBtn) {
			card.show(centerP, "home");
		}else if(e.getSource() == writeBtn) {
			card.show(centerP, "write");
		}else if(e.getSource() == loginBtn) {
			card.show(centerP, "login");
		}
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}










