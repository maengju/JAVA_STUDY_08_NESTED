package nested;

public class AbstractMain {

   public static void main(String[] args) {
      AbstractTest at = new AbstractTest() { //�͸� Inner Class
         @Override
         public void setName(String name) {//����
            
         }
      };
      
      InterA in = new InterA() {//�͸� Inner Class
    	 @Override
         public void aa() {}
    	 @Override
         public void bb() {}
      };
      
      AbstractExam ae = new AbstractExam() {
    	//Override�ص��ǰ� ���ص���.  
      };

   }
}