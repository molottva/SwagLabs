package swagLabs.helpers;

import lombok.Value;

public class DataHelper {
    @Value
    public static class UserLoginData {
        private final String login;
        private final String password;
    }

    public static UserLoginData getStandardValidUser() {
        return new UserLoginData("standard_user", "secret_sauce");
    }

    public static UserLoginData getLockedUser() {
        return new UserLoginData("locked_out_user", "secret_sauce");
    }

    public static UserLoginData getProblemUser() {
        return new UserLoginData("problem_user", "secret_sauce");
    }

    public static UserLoginData getPerformanceGlitchUser() {
        return new UserLoginData("performance_glitch_user", "secret_sauce");
    }
}
