/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.online_banking_system_cps406_projecct;

import java.sql.*;
/**
 *
 * @author dhruvpatel
 */
public class Connect {
  
  public static void main(String[] argvs){
     Connection conn = null;
    PreparedStatement stmt = null;
       //public static void main(String[] args){
        String name = "John Doe";
        String age = "non123";
        int phone = 123;
        String password = "123";
        int number = 1235;
        int exp = 123456778;
        try{
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Dhruv123");

            // Execute SQL query
            String sql = "INSERT INTO user_data (username, email,phone_no, password, card_number, Expire_date) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set parameters
            stmt.setString(1, name);
            stmt.setString(2, age);
            stmt.setInt(3,phone);
            stmt.setString(4,password);
stmt.setInt(5,number);
stmt.setInt(6,exp);
            // Execute statement
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    } 
}




//     public static void makeConnect(String userName, String emailAddress, int phoneNumber,String Userpassword, int CardNumber, int ExpireDate){
//     try{
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         // Open a connection
//            String url = "jdbc:mysql://localhost:3306/mysql";
//            String username = "root";
//            String password = "Dhruv123";
//            
//         //Setting user fields
//        String userId = userName;
//        String email = emailAddress;
//        int phone_no = phoneNumber;
//        String userPassword = Userpassword;
//        int cardNumber = CardNumber;
//        int expireDate = ExpireDate;
//         
//            connection = DriverManager.getConnection(url, username, password);
// // Create statement
//           //statement = connection.createStatement();
//
//            // Execute SQL query
//            //String sql = "INSERT INTO user_data (Paasword, Cnum) VALUES ('"+userName+"',"+emailAddress+"')";
//            
//           // String sqlQuery = "INSERT INTO user_data (username,email,phone_no,password,card_number,Expire_date) VALUES ('"+userId+"','"+email+"','"+phone_no+"','"+userPassword+"','"+cardNumber+"','"+expireDate+"',";
//           String sql = "INSERT INTO user_data (username, email) VALUES ('"+userId+"','"+email+"')";
//            //statement.executeQuery(sqlQuery);
//              PreparedStatement pr=connection.prepareStatement(sql);
//           
//                   pr.setString(0,userId);
// pr.setString(1,email);
// int addRows=pr.executeUpdate();
//                   //System.out.println(rowsAffected + " rows affected");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close resources
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//     }
//         public static void main(String[] args){
//             //Connect();
//}
//            
//     }
// 
//
//
//     
//     //public boolean Connection(){
////         try{
////                    Class.forName("com.mysql.cj.jdbc.Driver");
////                    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql/","root","Dhruv123");
////                    if(c!=null){
////                    System.out.println("Connection Successful");
////                    /*Statement stmt=c.createStatement();
////                    String sql="INSERT INTO Login (Card_num,Password)"+"VALUES(?,?)";
////                    PreparedStatement pr=c.prepareStatement(sql);
////                    pr.setInt(1, Card_num);
////                    pr.setString(2,Password);
////                    
////                    int addRows=pr.executeUpdate();
////                    if(addRows>0){
//                        Login=new Login();
//                        Login.Card_num=Card_num;
//                        Login.Password=Password;*/
//                    
//                      return true;
//                    }
//                }
//                    catch(Exception e){
//                    System.out.println(e);
//                    System.out.print("Not connected");
//                    
//                    }
//         return false;
//               
   // }
//    public void setDataToDb(String userName, String emailAddress) throws SQLException{
//        Statement statement = c.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM Login");
//        
//        while(resultSet.next()){
//            int Cnum = resultSet.getInt("Cnum");
//            String paasword = resultSet.getString("paasword");
//            System.out.println("Cnum: "+Cnum+"\npassword: "+paasword);
//        }
//        
//    }
    
     //}
     //public static void main(String[] argvs){
//                try{
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Dhruv123");
//                    if(c!=null){
//                    System.out.println("Connection Successful");
//                    /*Statement stmt=c.createStatement();
//                    String sql="INSERT INTO Login (Card_num,Password)"+"VALUES(?,?)";
//                    PreparedStatement pr=c.prepareStatement(sql);
//                    pr.setInt(1, Card_num);
//                    pr.setString(2,Password);
//                    
//                    int addRows=pr.executeUpdate();
//                    if(addRows>0){
//                        Login=new Login();
//                        Login.Card_num=Card_num;
//                        Login.Password=Password;*/
//                    
//                      
//                    }
//                }
//                    catch(Exception e){
//                    System.out.println(e);
//                    System.out.print("Not connected");
//                    }
//               
//    }
//    
//}
