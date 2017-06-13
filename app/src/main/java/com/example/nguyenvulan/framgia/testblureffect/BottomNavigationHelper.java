package com.example.nguyenvulan.framgia.testblureffect;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 13/06/2017.
 */

public class BottomNavigationHelper {
    public static void disableShiftMode(BottomNavigationView bottomNavigationView) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {
            Field field = bottomNavigationMenuView.getClass().getDeclaredField("mShiftingMode");
            field.setAccessible(true);
            field.setBoolean(bottomNavigationMenuView, false);
            field.setAccessible(false);
            for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
