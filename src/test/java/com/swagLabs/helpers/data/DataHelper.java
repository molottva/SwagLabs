package com.swagLabs.helpers.data;

import com.swagLabs.pages.generalPages.interfacePages.ItemInterface;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

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

    public static ItemData getItemData(ItemInterface item) {
        return new ItemData(item.getItemImageSrc(), item.getItemName(), item.getItemDescription(),
                convertItemPriceInCents(item));
    }

    public static int convertItemPriceInCents(ItemInterface item) {
        return Math.round(Float.valueOf(item.getItemPrice().substring(1)) * 100);
    }

    public static List<ItemData> getListItemsData(List<ItemInterface> items) {
        List<ItemData> listItemsData = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            listItemsData.add(getItemData(items.get(i)));
        }
        return listItemsData;
    }
}
