import country.JSONValidation;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        // the number of countries in the world
            System.out.println("Number of countries in the world: " + jsonValidation.noOfCountries(countries));

            // The country with the most official languages, where they officially speak German (de)
            System.out.println("The country with the most official languages, where they officially speak German (de): "
                    + jsonValidation.findCountryWithMostOfficialLanguagesWhereDEisSpoken(countries));

            // No of official languages spoken in the listed countries.
            System.out.println("No of official languages spoken in the listed countries: "
                    + jsonValidation.countTotalOfficialLanguages(countries));

            // The country with the highest number of official languages.
            System.out.println("The country with the highest number of official languages: "
                    + jsonValidation.findCountryWithMostOfficialLanguages(countries));

            // The most common official language(s), of all countries.
            System.out.println("The most common official language(s), of all countries: "
                    + jsonValidation.findMostCommonOfficialLanguage(countries));
        }

    private static JSONArray getCountries() {
        InputStream input = Main.class.getClassLoader().getResourceAsStream("country.json");
        String jsonTxt = null;
        try {
            jsonTxt = IOUtils.toString(input, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject json = new JSONObject(jsonTxt);
        JSONArray countries = json.getJSONArray("countries");
        return countries;
    }

}