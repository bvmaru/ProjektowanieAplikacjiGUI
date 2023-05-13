package app;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
/**
 * Program <code>MyWindow</code>
 * Klasa <code>MyLogger</code> definiujaca i obslugujaca
 * dziennik zdarzen� tzw. log. Wykorzystuje biblioteke log4j a konfiguracja
 * zawarta jest w pliku config/log4j-conf.xml
 * @author
 * @version 1.0	07/01/2011
 */
public class MyLogger {

    static final Logger logger = Logger.getLogger("logger");

    /**
     * Konstruktor bezparametrowy
     */
    public MyLogger() {
        DOMConfigurator.configure("config/log4j-conf.xml");
    }
    public static void writeLog(String level, String message) {
        if(level.equals("DEBUG")) logger.debug(message);
        else if(level.equals("INFO")) logger.info(message);
        else if(level.equals("WARN")) logger.warn(message);
        else if(level.equals("ERROR")) logger.error(message);
        else if(level.equals("FATAL")) logger.fatal(message);
    }
}
