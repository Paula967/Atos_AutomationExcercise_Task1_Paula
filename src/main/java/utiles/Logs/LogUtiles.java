package utiles.Logs;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogUtiles {
    private Logger logger= LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void info(String message){
        logger.info(message);
    }
    public void warning(String message){
        logger.warning(message);
    }
    public void severe(String message){
        logger.severe(message);
    }

}
