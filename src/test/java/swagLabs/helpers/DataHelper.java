package swagLabs.helpers;

import lombok.Value;
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
        private final String itemImageSrc;
        private final String itemName;
        private final String itemDescription;
        private final int itemPriceInCents;
    }

    public static ItemData getItemData(ItemComponent item) {
        return new ItemData(item.getItemImageSrc(), item.getItemName(), item.getItemDescription(), convertItemPriceInCents(item));
    }

    public static int convertItemPriceInCents(ItemComponent item) {
        return Math.round(Float.valueOf(item.getItemPrice().substring(1)) * 100);
    }
}
