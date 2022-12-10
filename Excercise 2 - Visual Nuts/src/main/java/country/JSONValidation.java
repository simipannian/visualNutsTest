package country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JSONValidation {

    public int noOfCountries(JSONArray countries){
        if(countries!=null && !countries.isEmpty()){
            return countries.length();
        }
        return 0;
    }

    public String findCountryWithMostOfficialLanguagesWhereDEisSpoken(JSONArray countries){

        if(countries!=null && !countries.isEmpty()){
            Map<String,Integer> officialLanguages = new HashMap<>();

            for (int i=0;i<countries.length();i++) {
                try {
                    JSONArray languages = new JSONObject(countries.get(i).toString()).getJSONArray("languages");
                    String country = new JSONObject(countries.get(i).toString()).get("country").toString();
                    for (int j=0;j<languages.length();j++) {
                        if(officialLanguages.keySet().contains(country) && languages.toString().contains("de")) {
                            officialLanguages.put(country, officialLanguages.get(country) + 1);
                        } else
                            officialLanguages.put(country, 1);

                    }

                }catch (JSONException err){
                    System.out.println("Exception while fetching json obj: " + err.getMessage());
                }
            }
            return getMostRepeatedString(officialLanguages);
        }

        return "";
    }

    public int countTotalOfficialLanguages(JSONArray countries){

        if(countries!=null && !countries.isEmpty()){
            ArrayList<String> officialLanguages = new ArrayList();
            for (int i=0;i<countries.length();i++) {
                try {
                    JSONArray languages = new JSONObject(countries.get(i).toString()).getJSONArray("languages");

                    for (int j=0;j<languages.length();j++) {
                        String currentLang = languages.get(j).toString();
                        if(!officialLanguages.contains(currentLang)){
                            officialLanguages.add(currentLang);
                        }
                    }

                }catch (JSONException err){
                    System.out.println("Exception while fetching json obj: " + err.getMessage());
                }
            }
            return officialLanguages.size();
        }
    return 0;
    }

    public String findCountryWithMostOfficialLanguages(JSONArray countries){

        if(countries!=null && !countries.isEmpty()){
            Map<String,Integer> officialLanguages = new HashMap<>();
            for (int i=0;i<countries.length();i++) {
                try {
                    JSONArray languages = new JSONObject(countries.get(i).toString()).getJSONArray("languages");
                    String country = new JSONObject(countries.get(i).toString()).get("country").toString();
                    for (int j=0;j<languages.length();j++) {
                        if(officialLanguages.keySet().contains(country))
                        officialLanguages.put(country, officialLanguages.get(country) + 1);
			            else
                            officialLanguages.put(country, 1);
                    }

                }catch (JSONException err){
                    System.out.println("Exception while fetching json obj: " + err.getMessage());
                }
            }
            return getMostRepeatedString(officialLanguages);
        }

        return "";
    }

    public String findMostCommonOfficialLanguage(JSONArray countries){
        if(countries!=null && !countries.isEmpty()){
            Map<String,Integer> officialLanguages = new HashMap<>();
            for (int i=0;i<countries.length();i++) {
                try {
                    JSONArray languages = new JSONObject(countries.get(i).toString()).getJSONArray("languages");

                    for (int j=0;j<languages.length();j++) {
                        String currentLang = languages.get(j).toString();
                        if(officialLanguages.keySet().contains(currentLang))
                            officialLanguages.put(currentLang, officialLanguages.get(currentLang) + 1);
                        else
                            officialLanguages.put(currentLang, 1);

                    }

                }catch (JSONException err){
                    System.out.println("Exception while fetching json obj: " + err.getMessage());
                }
            }
            return getMostRepeatedString(officialLanguages);
        }
    return "";
}
    private String getMostRepeatedString(Map<String, Integer> officialLanguages) {
        String maxStr = "";
        int maxVal = 0;
        for (Map.Entry<String,Integer> entry : officialLanguages.entrySet()) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            if (count > maxVal)
            {
                maxVal = count;
                maxStr = key;
            }
            // Condition for the tie.
            else if (count == maxVal){
                maxStr = maxStr + "," + key;
            }
        }
        return maxStr;
    }
}