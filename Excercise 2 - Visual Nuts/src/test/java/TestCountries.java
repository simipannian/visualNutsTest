import country.JSONValidation;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TestCountries {

    @Test
    public void testTotalNumberOfCountries() {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        int noOfCountries  = jsonValidation.noOfCountries(countries);
        assertEquals(5, noOfCountries);
    }

    @Test
    public void testFindCountryWithMostOfficialLanguagesWhereDEisSpoken() {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        String country  = jsonValidation.findCountryWithMostOfficialLanguagesWhereDEisSpoken(countries);
        assertEquals("BE,NL", country);
    }

    @Test
    public void testCountTotalOfficialLanguages() {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        int totalOfficialLanguages  = jsonValidation.countTotalOfficialLanguages(countries);
        assertEquals(6, totalOfficialLanguages);
    }

    @Test
    public void testFindCountryWithMostOfficialLanguages() {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        String country  = jsonValidation.findCountryWithMostOfficialLanguages(countries);
        assertEquals("ES", country);
    }

    @Test
    public void testFindMostCommonOfficialLanguage() {
        JSONValidation jsonValidation = new JSONValidation();
        JSONArray countries = getCountries();
        String language  = jsonValidation.findMostCommonOfficialLanguage(countries);
        assertEquals("de", language);
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
