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

//Frame-BorderLayout(��������), �������� �������� 1���� Component�� �ö󰣴�
public class MemberMain extends Frame implements ActionListener {
	private Button homeBtn, writeBtn, loginBtn;
	private CardLayout card;
	private Panel centerP;
	
	public MemberMain() {
		homeBtn = new Button("Ȩ");
		writeBtn = new Button("ȸ������");
		loginBtn = new Button("�α���");
		
		card = new CardLayout();
		
		//3���� ��ư
		Panel northP = new Panel(); //Panel-FlowLayout(������ġ)
		northP.setBackground(new Color(45, 180, 0));
		northP.add(homeBtn);
		northP.add(writeBtn);
		northP.add(loginBtn);
		
		//ī�巹�̾ƿ����� �� �г� �Դϴ� ���Ⱑ ��� �ٲ�̴ϴ�
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
		
		//�̺�Ʈ
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//��ư �̺�Ʈ
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










