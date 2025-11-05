package ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
    public static String currentTime() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}

