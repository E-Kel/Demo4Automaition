package constants;

import static connection.GetConstantsUtil.connectAndGetCookie;

public class Cookie {
    private Cookie() {
    }

    public static final String cookie1 = String.valueOf(connectAndGetCookie());

}
