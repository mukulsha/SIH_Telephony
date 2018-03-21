package com.example.android.sih_telephony;

/**
 * Created by divya on 2018-03-21.
 */

public class ColorPickerListItem {

    String percentage;
    String colorCode;

    public ColorPickerListItem() {

    }

    public ColorPickerListItem(String percentage, String colorCode) {
        this.percentage = percentage;
        this.colorCode = colorCode;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
