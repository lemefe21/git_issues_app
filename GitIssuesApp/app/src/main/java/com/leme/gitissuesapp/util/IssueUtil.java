package com.leme.gitissuesapp.util;

import com.leme.gitissuesapp.R;

public class IssueUtil {

    public static int setIconState(String state) {

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

    public static int setDividerState(String state) {

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
}
