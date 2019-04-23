package TeamProject;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class DatabaseTest
{ 
  private Database db;  
  private int rando;
  private ServerGUI serverGUI;
  private PlayerGUI clientGUI;
  private PlayerClient client;
  String [] animals = {"chimpanzee","octopus","porcupine","sheep","giraffe"};
  
  @Before
  public void setUp() throws Exception 
  {
    db = new Database(); 
    rando = ((int)Math.random()*animals.length); 

  }
  @Test
  public void testDatabaseConnection() throws FileNotFoundException
  {
    Connection con = db.getConnection();
    
    //check if database is connected
    assertNotNull("Check Database Connection", con);   
  }
  
  @Test
  public void testQuery() throws SQLException  
  {
    String expected = animals[rando];   
    ArrayList<String> animals_in_databse = db.query("select words from animals where words='" + expected +"';");
    String actual_animal = animals_in_databse.get(0);
    
    //compare expected with animals_in_databse using assertEquals
     assertEquals("Animal comparision", expected + "/", actual_animal);
  }
  
  
  
}
