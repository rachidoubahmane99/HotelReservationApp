package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Factory {
	
	public static Connection dbConnect(){
		
	Connection con = null;
    Properties properties = new Properties();
    final String FICHIER_PROPERTIES       = "/Dao/jdbc.properties";
    final String PROPERTY_URL             = "jdbc.url";
    final String PROPERTY_DRIVER          = "jdbc.driver";
    final String PROPERTY_NOM_UTILISATEUR = "jdbc.username";
    final String PROPERTY_MOT_DE_PASSE    = "jdbc.password";
    
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
    String url;
	String driver;
	String nomUtilisateur;
	String motDePasse;
    
	if ( fichierProperties == null ) {
        throw new DaoException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
    }
	try {
		properties.load(fichierProperties);
		url = properties.getProperty( PROPERTY_URL );
	    driver = properties.getProperty( PROPERTY_DRIVER );
	    nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
	    motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
	}catch ( IOException e ) {
        throw new DaoException( "Impossible de charger le fichier properties " , e );
    }
   
	
		
		try{
			
			Class.forName(driver);
			System.out.println("\n\n Driver approuvé");
			con = DriverManager.getConnection(url,nomUtilisateur,motDePasse);
			System.out.println("Connection a la base reussit");
		}catch(ClassNotFoundException e){
			 throw new DaoException( "Le driver est introuvable dans le classpath.", e );
		}
		catch(SQLException e){
			 throw new DaoException( "Connection a la base impossible :", e );

		}
		return con;
	}
	
	
	
	
	
	
	 
	
}
