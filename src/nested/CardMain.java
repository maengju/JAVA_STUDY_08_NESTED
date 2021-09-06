package nested;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CardMain {
   private Frame frame;
   private CardLayout card;
   
   public CardMain() {
	  frame = new Frame();
	  card = new CardLayout();
	  frame.setLayout(card);
	  
	  //panel 7�� ���� - �迭
	  Panel[] jp= new Panel[7];
	  Color[] color = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,
			  			Color.MAGENTA,Color.CYAN,Color.ORANGE};
	  String[] title = {"����","�ʷ�","�Ķ�","���","����","�ϴ�","��Ȳ"};
	  
	  for(int i=0; i<jp.length; i++) {
		  jp[i] = new Panel();//�г� ����
		  jp[i].setBackground(color[i]); // ������
		 
		  
		  frame.add(jp[i],title[i]);
	  }//for
	  
	  
	  //event
	  for(int i=0; i<jp.length; i++) {
		  jp[i].addMouseListener(new MouseAdapter() {
			  @Override
			public void mouseClicked(MouseEvent e) {
				//card.show(frame, "����"); //������ ������
				  card.next(frame); //�������� �Ѱ���
			}
		  });
		  
	  }//for
	  
	  
      frame.setBounds(900, 200, 200, 200);
      frame.setVisible(true);
      
      this.frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            
            System.exit(0); // ���α׷� ���� ����
         }
      });
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new CardMain();
   }

}
/*
Frame / JFrame  - BorderLayout (��������)
Panel			- FlowLayout(�߾�,������ġ)
				- GridLayout(�࿭��ġ)
Canvas			- null
				- CardLayout()
*/