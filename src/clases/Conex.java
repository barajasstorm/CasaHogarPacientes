/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sonny
 */
public class Conex {
    private String url;
    private String server;
    private String puerto;
    private String bd;
    private String user;
    private String pwd;
    private String driver;
    private String insSql;
    private static Conex instancia;
    private static Connection con;
    
    
    public static Conex getInstance(){
        
        if(instancia==null){
            instancia = new Conex();
        }
        return instancia;
    }
    private Conex(){
        server = "127.0.0.1";
        insSql = "";
        puerto="3306";
        bd="sagradafamilia";
        user="root";
        pwd = "password1";
        //pwd = "Abcd4321";
        driver="com.mysql.jdbc.Driver";
        
        if(insSql.trim().length() ==0){
          //String url2="jdbc:mysql://localhost:3306/tavern";
          url ="jdbc:mysql://" +server +":"+puerto+"/"+bd;
        }
     
        System.out.println(url);
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error a: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error b: " + ex.getMessage());
        }
         
    }
    public Connection getConnection(){
            return con;
        }  
         
}
