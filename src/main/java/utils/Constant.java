package utils;

public class Constant {

    public static final String BASE_URL = "https://www.hepsiburada.com/";
    public static final String IMPLICIT_WAIT_DURATION = "20";
    public static final String PAGE_LOAD_TIMEOUT = "180000";

    public static final String[] DRIVER_OPTIONS = {
            /**
            * Returns Driver Options
            */

            "--ignore-certificate-errors"
            , "--ignore-ssl-errors"
            , "--disable-notifications"
            , "--disable-infobars"
            , "start-maximized"
            , "--no-sandbox"
            , "--disable-notifications"
            , "--enable-automation"
            , "--incognito"
    };

}
