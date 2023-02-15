package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {

    private static ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }

    public static <T> T convertJsonIntoJava(String jsn, Class<T> cls){

        T actualData = null;

        try{
            actualData = mapper.readValue(jsn,cls);

        }catch (IOException e){
            e.printStackTrace();
        }
        return actualData;


    }

}
