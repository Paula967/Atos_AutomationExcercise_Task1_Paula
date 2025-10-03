package utiles.FileManager;

import org.apache.commons.io.FileUtils;
import utiles.Logs.LogUtiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtiles {
    private FileUtiles() {
        super();
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogUtiles.warn("No files found in directory: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogUtiles.warn("Directory does not exist" + dirPath);
            return;
        }
        File[] filesList = dirPath.listFiles();
        if (filesList == null) {
            LogUtiles.warn("Failed to list file in:" + dirPath);
            return;
        }
        for (File file : filesList) {
            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogUtiles.error("Failed to delete file : " + file);
                }
            }
        }

    }
    public static void cleanDirectory(File file) {
        try {
            FileUtils.deleteQuietly(file);
        } catch (Exception exception) {

            LogUtiles.error(exception.getMessage());

        }
    }

    public static void createDirectory(File path) {
        if (!path.exists()) {
            try {
                Files.createDirectories(path.toPath());
                LogUtiles.info("Directory created: " + path);
            } catch (IOException e) {
                LogUtiles.error("Failed to create directory: " + e.getMessage());
            }
        } else {
            LogUtiles.info("Directory already exists: " + path);
        }
    }
}
