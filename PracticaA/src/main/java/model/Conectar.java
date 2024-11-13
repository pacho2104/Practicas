package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
	
	
	
      private String url="jdbc:mysql://localhost/odontologico";
      private String user="root";
      private String pass="123456";
      protected Connection con;
       
      
      public void Conectar() {
    	  
    	  
    	  try {
			
    		   con=DriverManager.getConnection(url, user, pass);
    		   System.out.println("conexion okkkkkkkkkkkkkk");
    		  
    		  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al conectar:"+e.getMessage());
		}
    	  
    	 
    	  
    	  
      }
      
      public void Desconectar() {
    	  
    	  
    	  try {
			
    		  if(con !=null && !con.isClosed()) {
    		  
    		  con.close();
    	  }
    	  System.out.println("conexion cerrada");
    	  
    		  
    		  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en desconectar");
		}
    	  
    	  
    	  
    	  
      }
	
	
	
	

}
