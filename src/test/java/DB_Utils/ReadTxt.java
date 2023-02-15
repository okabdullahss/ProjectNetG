package DB_Utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {


    public static List<Object> returnPhysicianIDsList(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
             /*   User user = new User();
                user.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

                all.add(user.getId()); */
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



    public static List<String> returnPhysicianFirstName(String filePath){

        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
              /*  User user = new User();
                user.setFirstName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                all.add(user.getFirstName()); */
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnPhysicianLastName(String filePath){

        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
             /*
                User user = new User();
                user.setLastName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                all.add(user.getFirstName());  */
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

}