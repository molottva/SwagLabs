package swagLabs.helpers;

import lombok.Value;
import org.openqa.selenium.WebElement;
import swagLabs.pages.pageComponents.ItemComponent;

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

    @Value
    public static class ItemData {
        private final String itemName;
        private final String itemDescription;
        private final float itemPrice;
    }

    public static ItemData getItemData (ItemComponent item) {
        return new ItemData(item.getItemName(), item.getItemDescription(), item.getItemPrice());
    }
}
