import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PrintInteger {
    public String printInt(String resourcePath){
        try (
    InputStream input = Main.class.getClassLoader().getResourceAsStream(resourcePath)){
        Properties prop = new Properties();

        if (input == null) {
            System.out.println("Sorry, unable to find printIntegerConfig.properties");
            return "Not printed";
        }

        //load a properties file
        prop.load(input);

        //get the property value and assign to the print limit
        Integer printLimit = Integer.valueOf(prop.getProperty("print.limit"));
        for(int i = 1; i <= printLimit; i++) {
            if (i%3 == 0 && i%5 == 0){
                System.out.println("Visual Nuts");
            }else if(i%3 == 0){
                System.out.println("Visual");
            }else if(i%5 == 0){
                System.out.println("Nuts");
            }else{
                System.out.println(i);
            }
        }

    } catch (
    IOException ex) {
        ex.printStackTrace();

    }
        return "printed";
    }
}
