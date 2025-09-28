package utiles.datareaders;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

import static utiles.datareaders.JSONReaderUtil.readJson;

public class DataProviderUtils {

    public static Iterator<Object[]> getData(String filePath) throws IOException {
        String lowerPath = filePath.toLowerCase(Locale.ROOT);
        if (lowerPath.endsWith(".csv")) {
            return CSVReaderUtil.readCSV(filePath);
        } else if (lowerPath.endsWith(".xlsx")) {
            return ExcelReaderUtil.readExcel(filePath);
        } else if (lowerPath.endsWith(".json")) {
            return readJson(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
    @DataProvider(name = "jsonDataProvider")
    public static Iterator<Object[]> getDataFromFile(Method method) throws IOException {
        JsonFile fileAnnotation = method.getAnnotation(JsonFile.class);
        if (fileAnnotation == null) {
            throw new RuntimeException("Please annotate your test method with @JsonFile to specify the JSON path.");
        }
        return readJson(fileAnnotation.value());
    }
}
