package com.manu.mpopupwindow.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

/**
 * @Desc: MPopupWindow
 * @Author: jzman
 */
public class MPopupWindow {

    private Context mContext;
    private PopupWindow mPopupWindow;
    private Drawable mBackgroundDrawable;
    private OnDismissListener mOnDismissListener;
    private boolean mOutsideTouchable;
    private int mAnimationStyle;
    private int mWidth;
    private View mView;
    private int mLayoutId;
    private int mHeight;
    private int mOffsetX;
    private int mOffsetY;
    private boolean mTouchable;
    private View mTarget;
    private @TypeGravity int mGravity;

    private MPopupWindow() {
    }

    public static MPopupWindow.Builder create(Context context) {
        return new MPopupWindow.Builder(context);
    }

    public void show() {
        if (mView != null) {
            mPopupWindow.setContentView(mView);
        } else if (mLayoutId != -1) {
            View contentView = LayoutInflater.from(mContext).inflate(mLayoutId, null);
            mPopupWindow.setContentView(contentView);
        }
        if (mWidth != 0) mPopupWindow.setWidth(mWidth);
        if (mHeight != 0) mPopupWindow.setHeight(mHeight);
        mPopupWindow.setBackgroundDrawable(mBackgroundDrawable);
        mPopupWindow.setOutsideTouchable(mOutsideTouchable);
        mPopupWindow.setOnDismissListener(mOnDismissListener);
        mPopupWindow.setAnimationStyle(mAnimationStyle);
        mPopupWindow.setTouchable(mTouchable);

        int[] locations = new int[2];
        mTarget.getLocationOnScreen(locations);
        int left = locations[0];
        int top = locations[1];

        mPopupWindow.getContentView().measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int popupWidth = mPopupWindow.getContentView().getMeasuredWidth();
        int popupHeight = mPopupWindow.getContentView().getMeasuredHeight();
        int targetWidth = mTarget.getWidth();
        int targetHeight = mTarget.getHeight();

        switch (mGravity) {
            case TypeGravity.TOP_LEFT:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + mOffsetX, top - popupHeight + mOffsetY);
                break;
            case TypeGravity.TOP_CENTER:
                int offsetX = (targetWidth - popupWidth) / 2;
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + offsetX + mOffsetX, top - popupHeight + mOffsetY);
                break;
            case TypeGravity.TOP_RIGHT:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + targetWidth - popupWidth + mOffsetX, top - popupHeight + mOffsetY);
                break;

            case TypeGravity.CENTER:
                int x = left + (targetWidth - popupWidth) / 2 + mOffsetX;
                int y = top + (targetHeight - popupHeight) / 2 + mOffsetY;
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, x, y);
                break;
            case TypeGravity.CENTER_LEFT_TOP:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + mOffsetX, top + mOffsetY);
                break;
            case TypeGravity.CENTER_LEFT_BOTTOM:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + mOffsetX, top + (targetWidth - popupHeight) + mOffsetY);
                break;
            case TypeGravity.CENTER_RIGHT_BOTTOM:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + (targetWidth - popupWidth) + mOffsetX, top + (targetHeight - popupHeight) + mOffsetY);
                break;
            case TypeGravity.CENTER_RIGHT_TOP:
                mPopupWindow.showAtLocation(mTarget, Gravity.NO_GRAVITY, left + (targetWidth - popupWidth) + mOffsetX, top + mOffsetY);
                break;

            case TypeGravity.BOTTOM_LEFT:
                mPopupWindow.showAsDropDown(mTarget, mOffsetX, mOffsetY);
                break;
            case TypeGravity.BOTTOM_CENTER:
                int offsetX1 = (targetWidth - popupWidth) / 2;
                mPopupWindow.showAsDropDown(mTarget, offsetX1 + mOffsetX, mOffsetY);
                break;
            case TypeGravity.BOTTOM_RIGHT:
                mPopupWindow.showAsDropDown(mTarget, targetWidth - popupWidth + mOffsetX, mOffsetY);
                break;

            case TypeGravity.FROM_BOTTOM:
                if (mWidth == 0) mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                mPopupWindow.showAtLocation(mTarget, Gravity.BOTTOM, mOffsetX, mOffsetY);
                break;
            case TypeGravity.FROM_TOP:
                if (mWidth == 0) mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                mPopupWindow.showAtLocation(mTarget, Gravity.TOP, mOffsetX, mOffsetY);
                break;
        }
    }

    public void dismiss() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
    }

    public static class Builder {
        private final Context context;
        private View contentView;
        private int layoutId;
        private final PopupWindow popupWindow;
        private boolean outsideTouchable;
        private Drawable backgroundDrawable;
        private OnDismissListener onDismissListener;
        private int animationStyle;
        private int width;
        private int height;
        private int offsetX;
        private int offsetY;
        private boolean touchable;
        private View target;
        private @TypeGravity int gravity;

        public Builder(Context context) {
            this.context = context;
            this.popupWindow = new PopupWindow(context);
            this.outsideTouchable = true;
            this.touchable = true;
            this.backgroundDrawable = new ColorDrawable(Color.TRANSPARENT);
            this.width = 0;
            this.height = 0;
            this.layoutId = -1;
            this.offsetX = 0;
            this.offsetY = 0;
            this.gravity = TypeGravity.CENTER;
        }

        public Builder setContentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public Builder setBackgroundDrawable(Drawable backgroundDrawable) {
            this.backgroundDrawable = backgroundDrawable;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setOutsideTouchable(boolean outsideTouchable) {
            this.outsideTouchable = outsideTouchable;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setOffsetX(int offsetX) {
            this.offsetX = offsetX;
            return this;
        }

        public Builder setOffsetY(int offsetY) {
            this.offsetY = offsetY;
            return this;
        }

        public Builder setGravity(@TypeGravity int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
            return this;
        }

        public Builder setAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public Builder setTouchable(boolean touchable) {
            this.touchable = touchable;
            return this;
        }

        public Builder setTarget(View target) {
            this.target = target;
            return this;
        }

        public MPopupWindow build() {
            MPopupWindow popupWindow = new MPopupWindow();
            setPopupWindowConfig(popupWindow);
            return popupWindow;
        }

        private void setPopupWindowConfig(MPopupWindow window) {
            if (context == null) {
                throw new MException("context can't be null.");
            } else {
                window.mContext = this.context;
            }

            if (contentView != null && layoutId != -1) {
                throw new MException("setContentView and setLayoutId can't be used together.");
            } else if (contentView == null && layoutId == -1) {
                throw new MException("contentView or layoutId can't be null.");
            }

            if (target == null){
                throw new MException("please set a target view");
            }

            window.mWidth = this.width;
            window.mHeight = this.height;
            window.mView = this.contentView;
            window.mLayoutId = layoutId;
            window.mPopupWindow = this.popupWindow;
            window.mOutsideTouchable = this.outsideTouchable;
            window.mBackgroundDrawable = this.backgroundDrawable;
            window.mOnDismissListener = this.onDismissListener;
            window.mAnimationStyle = this.animationStyle;
            window.mTouchable = this.touchable;
            window.mOffsetX = this.offsetX;
            window.mOffsetY = this.offsetY;
            window.mTarget = this.target;
            window.mGravity = this.gravity;
        }
    }
}
