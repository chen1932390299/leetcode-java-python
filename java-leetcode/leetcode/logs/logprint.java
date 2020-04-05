package logs;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;


public class logprint {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static Logger log = Logger.getLogger(logprint.class.toString());
    public static void main(String[] args) throws IOException {

    }

    public logprint() throws IOException {
        log.setLevel(Level.INFO);

    }
}
