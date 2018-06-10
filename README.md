
## MPopupWindow
一个通用的 PopupWindow，欢迎 star，也可以联系我一起交流学习！

![jzman-blog.jpg](https://upload-images.jianshu.io/upload_images/2494569-14e279a7599028e0.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## PopupWindow 正常的使用方式

```java
//创建PopupWindow
PopupWindow window = new PopupWindow(this);
//设置显示View
window.setContentView(contentView);
//设置宽高
window.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
window.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
//设置背景
window.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
//设置PopupWindow之外的触摸事件
window.setOutsideTouchable(true);
//设置PopupWindow消失的监听器
window.setOnDismissListener(new PopupWindow.OnDismissListener() {
    @Override
    public void onDismiss() {
        //监听PopupWindow的消失
    }
});
//设置PopupWindow上的触摸事件
window.setTouchable(true);
//设置PopupWindow弹出动画
window.setAnimationStyle(R.style.PopupWindowTranslateTheme);
window.showAtLocation(btnTarget, Gravity.BOTTOM | Gravity.CENTER, 0, 0);
```

#### 封装后的使用方式

```java

MPopupWindow popupWindow = new MPopupWindow
        .Builder(this)
        .setLayoutId(R.layout.popup_window_layout)//必须
        .setBackgroundDrawable(new ColorDrawable(Color.GRAY))//非必须
        .setWidth(WindowManager.LayoutParams.MATCH_PARENT)//非必须
        .setAnimationStyle(R.style.PopupWindowTranslateThemeFromBottom)//非必须
        .setGravity(Gravity.BOTTOM)//非必须
        .setOnDismissListener(new PopupWindow.OnDismissListener() {//非必须
            @Override
            public void onDismiss() {
                    Toast.makeText(MainActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
            }
        })
        .build();
popupWindow.showPopupWindow(btnTarget, type);

```

## 显示效果

![MPopupWindow.gif](https://upload-images.jianshu.io/upload_images/2494569-b398342589531f76.gif?imageMogr2/auto-orient/strip)
