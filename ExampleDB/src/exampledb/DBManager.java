package exampledb;

import java.sql.*;
import java.util.ArrayList;

public class DBManager 
{
    private static final String DB_FILENAME = "exampleDB.db";
    private static final String DB_PATH = "database/" + DB_FILENAME;
    
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
    
    public static ArrayList<TestObject> getData()
    {
        ArrayList<TestObject> list = new ArrayList<>();
        String sql = "SELECT * FROM Test";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                TestObject to = new TestObject(rs.getInt("ID"), rs.getString("Text"));
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
        String sql = "INSERT INTO test(ID,Text) VALUES(?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, to.getId());
            pstmt.setString(2, to.getText());
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
        String sql = "DELETE FROM Test WHERE ID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
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