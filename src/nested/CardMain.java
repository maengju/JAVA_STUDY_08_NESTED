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
	  
	  //panel 7개 생성 - 배열
	  Panel[] jp= new Panel[7];
	  Color[] color = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,
			  			Color.MAGENTA,Color.CYAN,Color.ORANGE};
	  String[] title = {"빨강","초록","파랑","노랑","보라","하늘","주황"};
	  
	  for(int i=0; i<jp.length; i++) {
		  jp[i] = new Panel();//패널 생성
		  jp[i].setBackground(color[i]); // 바탕색
		 
		  
		  frame.add(jp[i],title[i]);
	  }//for
	  
	  
	  //event
	  for(int i=0; i<jp.length; i++) {
		  jp[i].addMouseListener(new MouseAdapter() {
			  @Override
			public void mouseClicked(MouseEvent e) {
				//card.show(frame, "보라"); //지정된 곳으로
				  card.next(frame); //한장한장 넘겨줌
			}
		  });
		  
	  }//for
	  
	  
      frame.setBounds(900, 200, 200, 200);
      frame.setVisible(true);
      
      this.frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            
            System.exit(0); // 프로그램 강제 종료
         }
      });
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new CardMain();
   }

}
/*
Frame / JFrame  - BorderLayout (동서남북)
Panel			- FlowLayout(중앙,순서배치)
				- GridLayout(행열배치)
Canvas			- null
				- CardLayout()
*/