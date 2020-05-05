package constants;

import static connection.GetConstantsUtil.connectAndGetCookie;

public class Cookie {
    private Cookie() {
    }

    public static final String staticCookie = String.valueOf(connectAndGetCookie());

}
