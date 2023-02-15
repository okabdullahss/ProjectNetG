package DB_Utils;

import org.junit.Assert;
import org.junit.Test;
import utilities.ConfigReader;
import utilities.DatabaseUtility;


import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.getColumnData;

public class DBTest02 {

    @Test
    public void test01() {

        //DATABASE CONNECTION
        String url = ConfigReader.getProperty("databaseUrlPostgre");
        String user = ConfigReader.getProperty("databaseUser");
        String password = ConfigReader.getProperty("databasePassword");

        DatabaseUtility.createConnection(url,user,password);

        String query = "select * from physician";
        System.out.println(DatabaseUtility.getColumnNames(query) + "\n");


        //GETTING DOCTOR ID's
        System.out.println("=====================ID LIST==================");
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList + "\n");
        String fileName1 = "src/test/resources/testdata/DoktorID.txt";
        WriteToTxt.savePhysicianIds(fileName1, idList);


        //VALIDATE PHYSICIAN ID'S
        List<Object> actualPhysicianIDs = ReadTxt.returnPhysicianIDsList(fileName1);
        List<Object> expectedPhysicianIDs = new ArrayList<>();
        expectedPhysicianIDs.add(147333);
        expectedPhysicianIDs.add(154273);

        Assert.assertTrue("ID'S DO NOT MATCH", actualPhysicianIDs.containsAll(expectedPhysicianIDs));



        //GETTING DOCTOR ID'S and SAVE THEM INTO THE TEXT
        System.out.println("=====================PHYSiCiAN LIST==================");
        List<Object> nameList = getColumnData(query, "first_name");
        System.out.println(nameList + "\n");
        String fileName2 = "src/test/resources/testdata/DoktorName.txt";
        WriteToTxt.savePhysicianFirstName(fileName2, nameList);


        //VALIDATING NAMES
        List<String > actualPhysicianNames = ReadTxt.returnPhysicianFirstName(fileName2);
        List<String > expectedPhysicianNames = new ArrayList<>();
        expectedPhysicianNames.add("Yusuf");

        Assert.assertTrue("NAMES DO NOT MATCH", actualPhysicianNames.containsAll(expectedPhysicianNames));
    }
}