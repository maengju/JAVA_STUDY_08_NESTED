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
import java.sql.SQLException;
import java.util.Scanner;


public class WritePanel extends Panel{

	private Connection conn;
	private PreparedStatement pstmt;  //���̵� ����
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	
	MemberDTO md = new MemberDTO();
	
	Label nameL, idL, pwdL;
	TextField nameT, idT, pwdT,comT;
	Button writeBtn,resetBtn;
	
	
	public WritePanel() {
		
		setLayout(null);
		
		//����
		nameL = new Label("�̸�");
		idL = new Label("���̵�");
		pwdL = new Label("��й�ȣ");
		
		nameT = new TextField();
		idT = new TextField();
		pwdT = new TextField();
		comT = new TextField();
		
		writeBtn = new Button("����");
	    resetBtn= new Button("�ٽ��ۼ�");
	    
	    nameL.setBounds(70, 50,100,40);
	    idL.setBounds(70, 100, 100, 40);
	    pwdL.setBounds(70,160,100,40);
	     
	    nameT.setBounds(210,50,200,40);
	    idT.setBounds(210,100,200,40);
	    pwdT.setBounds(210,160,200,40);
	    comT.setBounds(210,280,100,20);
	      
	    
	    writeBtn.setBounds(170,210,90,50);
	    resetBtn.setBounds(270,210,90,50);
	    
	    add(nameL);
	    add(idL);
	    add(pwdL);
	    
	    add(nameT);
	    add(idT);
	    add(pwdT);
	    add(comT);
	    
	    add(writeBtn);
	    add(resetBtn);
	   
	    resetBtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		 nameT.setText("");
		         idT.setText("");//�ʱ�ȭ
		         pwdT.setText("");
	    		
	    	}
	    });
	    writeBtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		String name = nameT.getText();
		         String id = idT.getText();
		         String pwd = pwdT.getText();
		       
		         md.setName(name);
		         md.setId(id);
		         md.setPwd(pwd);
		         
		         Insert();
		         insertArticle();
		         comT.setText("���ԿϷ�");
	    		
	    	}
	    });
	}

	
	public void Insert() {

		try {
		//driver loading
		Class.forName(driver); //�̸��� �˰� ��Ȯ�� �𸦰��
		// ���ϸ�(Ǯ���� - ��Ű����.���ϸ�)�� �ָ� Class���� ������ ���ش�.
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); // ���� ������ ���
		}
	}
	
	public void getConnection() {
		try {
		
		conn = DriverManager.getConnection(url,username,password ); //����Ŭ ����̹� 3���� ���̾��°� thin
									//(URL,USERNAME,PASSWORD)
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertArticle() {
			String name = md.getName();
			String id = md.getId();
			String pwd = md.getPwd();
		
				
		try {
			//����
			this.getConnection();
			
			String sql = "insert into member values(?, ?, ?)";
			//����
			pstmt = conn.prepareStatement(sql);
			//?�� ������ ����
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3,pwd);
			
			//����
			int su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//������ �ְǾ��� ������ ����
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
