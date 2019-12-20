package exampledb;

import java.sql.*;
import java.util.ArrayList;

public class DBManager 
{
    //Der relative Pfad zur Datenbank, ausgehend von euren Projektordner
    private static final String DB_FILENAME = "exampleDB.db";
    private static final String DB_PATH = "database/" + DB_FILENAME;
    
   //Erstellt eine Verdinung zur Datenbank, welche für die Abfragen später benötigt wird.
    private static Connection connect() 
    {
        String url = "jdbc:sqlite:" + DB_PATH;
        Connection connection = null;
        try 
        {
            connection = DriverManager.getConnection(url);
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    //Rufe die gesamte Tabelle "Test" ab und erstellt eine ArrayList mit TestObjects
    public static ArrayList<TestObject> getData()
    {
        ArrayList<TestObject> list = new ArrayList<>();
        String sql = "SELECT * FROM Test";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            
            //Iteriert durch das gesamte Ergebnis der Abfrage 
            //und ertellt für jede Zeile ein neues Testobjekt
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("ID"); 
                String text = resultSet.getString("Text"); 
                TestObject to = new TestObject(id, text);
                list.add(to);
            }
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void insertData(TestObject to) 
    {
        //SQL statement wird vorbereitet, noch mit variablen Werten
        //die beiden Fragezeichen entspechen hier den Werten für ID und Text
        String sql = "INSERT INTO test(ID,Text) VALUES(?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            //füllt das SQL statement mit den Werten des TestObjects, welches übergeben wurde
            //erstes Fragezeichen wird mit der ID  des übergebenen TestObjects gefüllt
            pstmt.setInt(1, to.getId());
            //zweites Fragezeichen wird mit dem Text des übergebenen TestObjects gefüllt
            pstmt.setString(2, to.getText());
            //Nun vollständigers SQL statement wird jetzt ausgeführt
            pstmt.executeUpdate();
            System.out.println("[Log] " + to + " added into database.");
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteData(TestObject to) 
    {
        //SQL statement wird vorbereitet, noch mit variablen Werten
        String sql = "DELETE FROM Test WHERE ID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            //füllt das SQL statement mit den Werten des TestObjektes, welches übergeben wurde
            //Fragezeichen wird mit der ID gefüllt
            pstmt.setInt(1, to.getId());
            pstmt.executeUpdate();
            System.out.println("[Log] " + to + " removed from database.");
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}