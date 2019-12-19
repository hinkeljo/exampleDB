package exampledb;

import java.util.ArrayList;

public class ExampleDB 
{    
    public static void main(String[] args) 
    {
        ArrayList<TestObject> list = DBManager.getData(); 
        for(TestObject to: list)
        {
            System.out.println(to.toString());
        }
        int maxID = getMaxID(list); 
        TestObject newTO = new TestObject(++maxID, "NEU" + maxID);
        DBManager.insertData(newTO);
        DBManager.deleteData(newTO);
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
}