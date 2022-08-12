package swagLabs.helpers;

import lombok.Value;

public class DataHelper {
    @Value
    public static class UserLoginData {
        private final String login;
        private final String password;
    }

    public static UserLoginData getStandardUser() {
        return new UserLoginData("standard_user", "secret_sauce");
    }
}
