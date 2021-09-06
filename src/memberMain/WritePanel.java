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
	private PreparedStatement pstmt;  //가이드 역할
	
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
		
		//생성
		nameL = new Label("이름");
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		nameT = new TextField();
		idT = new TextField();
		pwdT = new TextField();
		comT = new TextField();
		
		writeBtn = new Button("가입");
	    resetBtn= new Button("다시작성");
	    
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
		         idT.setText("");//초기화
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
		         comT.setText("가입완료");
	    		
	    	}
	    });
	}

	
	public void Insert() {

		try {
		//driver loading
		Class.forName(driver); //이름만 알고 정확히 모를경우
		// 파일명(풀네임 - 패키지명.파일명)을 주면 Class으로 생성을 해준다.
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); // 에러 내용을 출력
		}
	}
	
	public void getConnection() {
		try {
		
		conn = DriverManager.getConnection(url,username,password ); //오라클 드라이버 3개중 많이쓰는게 thin
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
			//접속
			this.getConnection();
			
			String sql = "insert into member values(?, ?, ?)";
			//생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 매핑
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3,pwd);
			
			//실행
			int su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//에러가 있건없건 무조건 실행
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
