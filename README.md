[![](https://jitpack.io/v/jzmanu/MPopupWindow.svg)](https://jitpack.io/#jzmanu/MPopupWindow)

## MPopupWindow

一个通用的 PopupWindow 的封装，欢迎 star！

### 使用方式

1. 添加 jitpack 仓库地址：

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

2. 添加依赖

```groovy
dependencies {
	  implementation 'com.github.jzmanu:MPopupWindow:v1.0.0'
}
```

#### 使用方式

```java
MPopupWindow.create(this)
      .setLayoutId(R.layout.popup_window_layout)
      .setBackgroundDrawable(ColorDrawable(Color.GREEN))
      .setAnimationStyle(R.style.PopupWindowScaleTheme)
      .setOnDismissListener {}
      .setTarget(mTarget)
      .setGravity(gravity)
      .build()
      .show()
```

## 显示效果

![MPopupWindow.gif](https://gitee.com/jzmanu/MPopupWindow/raw/master/screenshot/mpopupwinow.gif)

## 联系我

![jzman-blog.jpg](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/30958cc93b4641d183db8bffe0640c4b~tplv-k3u1fbpfcp-zoom-1.image)
