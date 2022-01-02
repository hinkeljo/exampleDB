package exampledb;

import java.sql.*;
import java.util.ArrayList;

public class DBManager 
{
    //relative path to the database, starting at your project folder
    private static final String DB_FILENAME = "exampleDB.db";
    private static final String DB_PATH = "database/" + DB_FILENAME;
    
    /**
     * creates a connection to the database, which is required for queries
     * @return database connection 
     */
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
    
    /**
     * Gets all data from the table "test" and creates an ArrayList with test objects
     * @return ArrayList of test objects from the database
     */
    public static ArrayList<TestObject> getData()
    {
        ArrayList<TestObject> list = new ArrayList<>();
        String sql = "SELECT * FROM Test";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            
            //iterates through the entire result of the query 
            //and creates a new object for each row
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
    
    /**
     * Inserts the specified TestObject into the database
     * @param to TestObject to be saved in the database
     */
    public static void insertData(TestObject to) 
    {
        //SQL query is prepared with not fixed values
        //The question marks (?) will be replaced by the actual values for the ID and the text
        String sql = "INSERT INTO test(ID,Text) VALUES(?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            //fills the sql statement with the values of the TestObject that was given in the parameters
            //first question mark is replaced with the ID
            pstmt.setInt(1, to.getId());
            //second question mark is replaced with the text
            pstmt.setString(2, to.getText());
            //now completed sql statement is executed
            pstmt.executeUpdate();
            System.out.println("[Log] " + to + " added into database.");
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Deletes the specified TestObject from the database
     * @param to Object to be deleted
     */
    public static void deleteData(TestObject to) 
    {
        //SQL query is prepared with not fixed values
        String sql = "DELETE FROM Test WHERE ID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            //fills the sql statement with the values of the TestObject that was given in the parameters
            //question mark is replaced with the ID
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
    
    public static void updateData(int index, String text) {
        //SQL query is prepared with not fixed values
        String sql = "UPDATE Test SET Text = ? WHERE ID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            //fills the sql statement with the values of the TestObject that was given in the parameters
            //first question mark is replaced with the text
            pstmt.setString(1, text);
            //second question mark is replaced with the ID
            pstmt.setInt(2, index);
            pstmt.executeUpdate();
            System.out.println("[Log] Item: " + index + " updated with text: " + text + ".");
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}