package com.leme.gitissuesapp.util;

import com.leme.gitissuesapp.R;

public class IssueUtil {

    public static int getResourceByIconState(String state) {

        switch (state) {
            case "open":
                return R.drawable.ic_lock_open_green_48dp;
            case "closed":
                return R.drawable.ic_lock_red_48dp;
            case "all":
                return R.drawable.ic_inbox_all_state_48dp;
            default:
                return R.drawable.ic_lock_open_green_48dp;
        }

    }

    public static int getResourceByDetailStateColor(String state) {

        switch (state) {
            case "open":
                return R.color.colorSecondaryLight;
            case "closed":
                return R.color.colorAccentIssueLight;
            case "all":
                return R.color.colorText;
            default:
                return R.color.colorSecondaryLight;
        }

    }

    public static int getResourceByBannerState(String state) {

        switch (state) {
            case "open":
                return R.color.colorSecondary;
            case "closed":
                return R.color.colorAccentIssue;
            case "all":
                return R.color.colorText;
            default:
                return R.color.colorSecondary;
        }

    }

    public static int getResourceColorByButtonState(String state) {

        switch (state) {
            case "open":
                return R.drawable.button_selection_open;
            case "closed":
                return R.drawable.button_selection_closed;
            case "all":
                return R.drawable.button_selection_all;
            default:
                return R.drawable.button_selection_open;
        }

    }

    public static int getResourceColorFontByButtonState(String state) {

        if(state.equals("all")) {
            return R.color.colorPrimary;
        } else {
            return R.color.colorText;
        }

    }

}
