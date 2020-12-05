package com.manu.mpopupwindow;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Desc: TypeGravity
 * @Author: jzman
 */
@IntDef({TypeGravity.TOP_LEFT, TypeGravity.TOP_CENTER, TypeGravity.TOP_RIGHT,TypeGravity.FROM_TOP,
        TypeGravity.CENTER_LEFT_TOP, TypeGravity.CENTER_RIGHT_TOP, TypeGravity.CENTER_LEFT_BOTTOM,
        TypeGravity.CENTER_RIGHT_BOTTOM, TypeGravity.CENTER, TypeGravity.BOTTOM_LEFT,
        TypeGravity.BOTTOM_CENTER, TypeGravity.BOTTOM_RIGHT,TypeGravity.FROM_BOTTOM})
@Retention(RetentionPolicy.SOURCE)
public @interface TypeGravity {
    int TOP_LEFT = 0;
    int TOP_CENTER = 1;
    int TOP_RIGHT = 2;

    int CENTER_LEFT_TOP = 3;
    int CENTER_RIGHT_TOP = 4;
    int CENTER_LEFT_BOTTOM = 5;
    int CENTER_RIGHT_BOTTOM = 6;
    int CENTER = 7;

    int BOTTOM_LEFT = 8;
    int BOTTOM_CENTER = 9;
    int BOTTOM_RIGHT = 10;

    int FROM_BOTTOM = 11;
    int FROM_TOP = 12;
}
