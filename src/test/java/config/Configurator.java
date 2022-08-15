package config;

import com.google.gson.Gson;
import config.models.JsonStructure;

import java.io.FileReader;

public class Configurator {
    public static JsonStructure AppSettings;

    static {
        AppSettings = parseAppSettings();
    }

    public static JsonStructure parseAppSettings(){
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("src/test/resources/jsons/appsettings.json")) {
            return gson.fromJson(reader, JsonStructure.class);
        }
        catch (Exception e){
            System.out.println("Parsing error: " + e.getMessage());
        }
        return null;
    }


}
