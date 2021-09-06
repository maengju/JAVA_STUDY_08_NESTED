package nested;

public class AbstractMain {

   public static void main(String[] args) {
      AbstractTest at = new AbstractTest() { //익명 Inner Class
         @Override
         public void setName(String name) {//구현
            
         }
      };
      
      InterA in = new InterA() {//익명 Inner Class
    	 @Override
         public void aa() {}
    	 @Override
         public void bb() {}
      };
      
      AbstractExam ae = new AbstractExam() {
    	//Override해도되고 안해도됨.  
      };

   }
}