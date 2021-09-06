package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RGBMain extends Frame  {//implements <오버라이드 하겠다.
	private Button redBtn,greenBtn,blueBtn;
	private DrCanvas can;
	
   public RGBMain() {
	   redBtn = new Button ("Red");
	   greenBtn = new Button ("Green");
	   blueBtn = new Button ("Blue");
	   can = new DrCanvas();
	   
	   Panel p = new Panel();
	  
	   p.add(redBtn);
	   p.add(greenBtn);
	   p.add(blueBtn);
	   
	   this.add("North",p);
	   this.add("Center",can);
	   
      setBounds(900,150,300,400);
      setVisible(true);
      //이벤트 걸어주기
      
      this.addWindowListener(new WindowAdapter() {
    	  @Override
         public void windowClosing(WindowEvent e) {
            System.out.println("프로그램 종료");
            System.exit(0); // 프로그램 강제 종료
         }
      });
      //windowAdapter는 추상클래스라서 절대 new할 수 없기에
      //익명 클래스를 사용한다. - 반드시 override해야 할 메소드가 없다.
   
      this.addMouseListener(new MouseAdapter() {
    	  @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println("마우스 클릭");

         }
      });
      redBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.RED); 
    	  }
      });//빨강
      greenBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.GREEN); 
    	  }
      });//초록
      blueBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.BLUE); 
    	  }
      });//파랑
      
      
      
   }//RGBMain()

   class DrCanvas extends Canvas {
	   public DrCanvas() {
		   this.setBackground(new Color(255,200,255));
	   }
	   
   }
   
   public static void main(String[] args) {
	   new RGBMain();
   }
}
