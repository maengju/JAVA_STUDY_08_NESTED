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

public class RGBMain extends Frame  {//implements <�������̵� �ϰڴ�.
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
      //�̺�Ʈ �ɾ��ֱ�
      
      this.addWindowListener(new WindowAdapter() {
    	  @Override
         public void windowClosing(WindowEvent e) {
            System.out.println("���α׷� ����");
            System.exit(0); // ���α׷� ���� ����
         }
      });
      //windowAdapter�� �߻�Ŭ������ ���� new�� �� ���⿡
      //�͸� Ŭ������ ����Ѵ�. - �ݵ�� override�ؾ� �� �޼ҵ尡 ����.
   
      this.addMouseListener(new MouseAdapter() {
    	  @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println("���콺 Ŭ��");

         }
      });
      redBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.RED); 
    	  }
      });//����
      greenBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.GREEN); 
    	  }
      });//�ʷ�
      blueBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		 can.setBackground(Color.BLUE); 
    	  }
      });//�Ķ�
      
      
      
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
