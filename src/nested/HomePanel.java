package nested;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class HomePanel extends Panel {
	public HomePanel() {
		//this.setBackground(Color.RED);
	}
	
	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("image/study.gif");
		g.drawImage(img, 30, 50, this);

	}
}












