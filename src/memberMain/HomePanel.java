package memberMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;



public class HomePanel extends Panel{

	
	
	public HomePanel() {
		setFont(new Font("���� ���",Font.BOLD,20));
		
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawString("�ȳ��ϼ���.", 210, 50);//�۾���
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("image/mokoko.jpg");
		g.drawImage(img, 0, 60, this);
		
	}

}
