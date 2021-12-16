package dao;
import java.util.ArrayList;
import connectToDatabase.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Utilisateur;
public class UtilisateurDAO {
	Connection newConnection;
	
	private static int LastId=0;
	private static ArrayList<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
	
	public UtilisateurDAO(){
		newConnection = new ConnectToDatabase().getConnection();
	}
	
	public boolean  ajouter(Utilisateur utilisateur) {
		String query = " insert into users (ID   , fullName, login, password, role)"
		        + " values (0 ,?, ?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = newConnection.prepareStatement(query);
				  preparedStmt.setString (1, utilisateur.getNom()+utilisateur.getPrenom());
			      preparedStmt.setString (2, utilisateur.getLogin());
			      preparedStmt.setString (3, utilisateur.getPassword());
			      preparedStmt.setString (4, "user");			 
			      preparedStmt.execute();
			      return true;
			} catch (SQLException e) {
				 System.out.println(e);
			      return false;
			}
	}
	public ArrayList<Utilisateur> Lister() {
		utilisateurs.clear();
		String query = "select * from users";
	    try (Statement stmt = newConnection.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
//	        String userName = rs.getString("fullName");
//	        String userMail = rs.getString("login");
//	        System.out.println("User mail : "+userMail+", User name : "+userName);
	        Utilisateur user = new Utilisateur(rs.getInt("ID"), rs.getString("fullName"), "", rs.getString("login"), "");
	        utilisateurs.add(user);
	      }
	    } catch (SQLException e) {
	      System.out.println(e);
	    }
	  return  utilisateurs;
	  
		
	}
	public boolean supprimer(int id) {
		System.out.println("ID " + id);
		String query = "delete from users where ID = ?";
		try {
			PreparedStatement preparedStmt = newConnection.prepareStatement(query);
		    preparedStmt.setInt(1, id);
		    preparedStmt.execute();
		    return true;
		}
		catch(SQLException e)
		{
			 System.out.println(e);
			 return false;
	    }
	}
	public Utilisateur get(int id) {
		String query = "select * from users where ID ="+id;
		try (Statement stmt = newConnection.createStatement()) {
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next())
		      {
		    	  Utilisateur user = new Utilisateur(rs.getInt("ID"), rs.getString("fullName"), "", rs.getString("login"), "");
			      System.out.println("Update "+user);
			      return user;
		      }		      
		    } catch (SQLException e) {
		      System.out.println(e);
		      return new Utilisateur();
		    }
		return null;
	}

	public Utilisateur getByLogin(String login) {
		
		String query = "select * from users where login ='"+login+"'";
		
		try (Statement stmt = newConnection.createStatement()) {
		      ResultSet rs = stmt.executeQuery(query);
		      if (rs.next()) {
		    	  Utilisateur user = new Utilisateur(rs.getInt("ID"), rs.getString("fullName"), "", rs.getString("login"), rs.getString("password"));
			      return user;
		      }
		    } catch (SQLException e) {
		      System.out.println(e);
		    }

	      return null;
	}
	
	public boolean modifier(Utilisateur utilisateur) {
		

		String query = "Update users set "
				//+ "login='"+String.valueOf(utilisateur.getLogin())+"' AND "
				+ "fullName= '"+String.valueOf(utilisateur.getPrenom())+"' "
				+ " where ID = "+utilisateur.getId();
		
		
		try (Statement stmt = newConnection.createStatement()) {
		       stmt.executeUpdate(query);
		       return true;		  	      
		    } catch (SQLException e) {
		      System.out.println(e);
		      return false;
		    }
		
	}
	
	

}
