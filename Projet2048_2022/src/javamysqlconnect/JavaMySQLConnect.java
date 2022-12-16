/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamysqlconnect;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ikram
 */
public class JavaMySQLConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Projet2048","projet2048","ProjetJava123");
            System.out.println("Vous etes connecte");  
            Statement stmt=con.createStatement();//réalise les requêtes base sur la associée à la connexion dont il dépend
            String query = "SELECT idUtilisateur FROM utilisateur ORDER BY id_utilisateurs ASC";
            ResultSet rs=stmt.executeQuery(
                    query);
            ArrayList<Integer> idUtilisateur = new ArrayList<>();
                    while (rs.next()) {
                        idUtilisateur.add(rs.getInt("id_utilisateurs"));
            System.out.println("Pseudo");
                    }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
          
}
    

