package memberMain;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemberMain implements ActionListener {
	
	 private Frame frame;
	 private CardLayout card;	
	 private Panel hp,wp,lp,bp,tp;
	 private Button hBtn,wBtn,lBtn;
	 
	 public MemberMain() {
		 frame = new Frame();
		 card = new CardLayout();
		 
		 hBtn = new Button("Home");
		 wBtn = new Button("회원가입");
		 lBtn = new Button("로그인");
		 
		 hp = new HomePanel();
		 wp = new WritePanel();
		 lp = new LoginPanel();
		 
		 
		 
		 tp = new Panel();   // 카드 패널
		 tp.setLayout(card);
		 tp.add(hp,"Home");
		 tp.add(wp,"회원가입");
		 tp.add(lp,"로그인");
		 
		 
		 bp = new Panel(); // 버튼 패널
		 bp.add(hBtn);
		 bp.add(wBtn);
		 bp.add(lBtn);
		 
		 frame.add("North",bp);   //프레임에 버튼 삽입
		 frame.add("Center",tp);   // 프레임 중앙에 카드패널 삽입
		
		
		 frame.setBounds(400, 150, 550, 550);
	     frame.setResizable(false);
		 frame.setVisible(true);
	     
	     
	     //이벤트 
	     hBtn.addActionListener(this);
	     wBtn.addActionListener(this);
	     lBtn.addActionListener(this);
	    
	     
	     this.frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	           System.exit(0); // 프로그램 강제 종료
	         }
	      });
	      
	 }
	 

		@Override
		public void actionPerformed(ActionEvent e) {
			
			 if(e.getSource()==hBtn) {
				card.show(tp,"Home");
		      }else if(e.getSource()==wBtn) {
		    	card.show(tp,"회원가입");
		      }else if(e.getSource()==lBtn) {
		    	 
		    	card.show(tp,"로그인");   
			  } 

			
		}


	
	
	public static void main(String[] args) {
		
		new MemberMain();

	}



}
