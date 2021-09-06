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
		 wBtn = new Button("ȸ������");
		 lBtn = new Button("�α���");
		 
		 hp = new HomePanel();
		 wp = new WritePanel();
		 lp = new LoginPanel();
		 
		 
		 
		 tp = new Panel();   // ī�� �г�
		 tp.setLayout(card);
		 tp.add(hp,"Home");
		 tp.add(wp,"ȸ������");
		 tp.add(lp,"�α���");
		 
		 
		 bp = new Panel(); // ��ư �г�
		 bp.add(hBtn);
		 bp.add(wBtn);
		 bp.add(lBtn);
		 
		 frame.add("North",bp);   //�����ӿ� ��ư ����
		 frame.add("Center",tp);   // ������ �߾ӿ� ī���г� ����
		
		
		 frame.setBounds(400, 150, 550, 550);
	     frame.setResizable(false);
		 frame.setVisible(true);
	     
	     
	     //�̺�Ʈ 
	     hBtn.addActionListener(this);
	     wBtn.addActionListener(this);
	     lBtn.addActionListener(this);
	    
	     
	     this.frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	           System.exit(0); // ���α׷� ���� ����
	         }
	      });
	      
	 }
	 

		@Override
		public void actionPerformed(ActionEvent e) {
			
			 if(e.getSource()==hBtn) {
				card.show(tp,"Home");
		      }else if(e.getSource()==wBtn) {
		    	card.show(tp,"ȸ������");
		      }else if(e.getSource()==lBtn) {
		    	 
		    	card.show(tp,"�α���");   
			  } 

			
		}


	
	
	public static void main(String[] args) {
		
		new MemberMain();

	}



}
