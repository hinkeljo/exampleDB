package exampledb;

import java.util.ArrayList;
import java.util.Random;

public class ExampleDB 
{    
    public static void main(String[] args) 
    {
        //get data from database and print it out
        ArrayList<TestObject> list = DBManager.getData(); 
        for(TestObject to: list)
        {
            System.out.println(to.toString());
        }
        
        int maxID = getMaxID(list); 
        TestObject newTO = new TestObject(++maxID, "NEU " + maxID);
        
        DBManager.insertData(newTO);
        DBManager.deleteData(newTO);
        DBManager.updateData(1, randomString());
        System.out.println("[Log] Finished.");
    }
    
    private static int getMaxID(ArrayList<TestObject> list)
    {
        int i = 0; 
        for(TestObject to: list)
        {
            if(to.getId() > i) i = to.getId(); 
        }
        return i; 
    }
    
    /**
     * Creates a random alphanumeric string with 10 characters
     * @return Generated string
     */
    private static String randomString() {
        return new Random().ints(48, 122 + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(10)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}