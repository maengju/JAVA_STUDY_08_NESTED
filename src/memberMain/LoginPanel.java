package memberMain;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPanel extends Panel implements ActionListener{
	
	private Connection conn=null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	Label idL, pwdL;
	TextField idT, pwdT,comT;
	Button loginBtn,resetBtn;
	 String id,pwd;
	
	public LoginPanel() {
		setLayout(null);
		
		
		idL = new Label("���̵�");
		pwdL = new Label("��й�ȣ");
		
		
		idT = new TextField();
		pwdT = new TextField();
		comT = new TextField();
		
		loginBtn = new Button("�α���");
	    resetBtn= new Button("�ٽ��ۼ�");
	    
	   
	    idL.setBounds(90, 80, 100, 40);
	    pwdL.setBounds(90,140,100,40);
	     
	    
	    idT.setBounds(230,80,200,40);
	    pwdT.setBounds(230,140,200,40);
	    comT.setBounds(210,300,100,20);
	      
	    
	    loginBtn.setBounds(170,200,90,50);
	    resetBtn.setBounds(270,200,90,50);
	    
	    
	    add(idL);
	    add(pwdL);
	    
	   
	    add(idT);
	    add(pwdT);
	    add(comT);
	    
	    add(loginBtn);
	    add(resetBtn);
	    
	    resetBtn.addActionListener(this);
	    loginBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==resetBtn) {
	         idT.setText("");//�ʱ�ȭ
	         pwdT.setText("");
	      }else if(e.getSource()==loginBtn) {
	        id = idT.getText();
	        pwd = pwdT.getText();
	        
	        Select();
	        SelectArticle();
	         
	      }
		
	}
	
	
	public void Select() {
	      try {
	         Class.forName(driver);
	      }catch(ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	}
	   
   public void getConnection() {
      try {
         conn = DriverManager.getConnection(url, username, password);
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }
   
	
   
   public void SelectArticle() {
		
		
		this.getConnection();
		
		try {

			
			String sql = "select * from member where id = ?";
			
			pstmt = conn.prepareStatement(sql);//����
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();//����
			
			 while(rs.next()) {
				 if(rs.getString("id").equals(id)&&rs.getString("pwd").equals(pwd)) {
					 comT.setText("�α��� �Ϸ�");
				 }else comT.setText("�α��� ����");
	        	 
	         }         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
		
	}//�̸������Ͽ� �˻�   
	

}
