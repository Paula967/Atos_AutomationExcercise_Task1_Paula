package utiles.datareaders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONReaderUtil {

    public static Iterator<Object[]> readJson(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        Gson gson = new Gson();

        //
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> jsonData = gson.fromJson(new FileReader(filePath), listType);

        for (Map<String, Object> entry : jsonData) {
            data.add(entry.values().toArray());
        }

        return data.iterator();
    }

}

