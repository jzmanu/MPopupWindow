package com.manu.mpopupwindow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.manu.mpopupwindow.widget.MPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.BOTTOM_CENTER;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.BOTTOM_LEFT;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.BOTTOM_RIGHT;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.FROM_BOTTOM;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.LEFT_BOTTOM;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.LEFT_CENTER;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.LEFT_TOP;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.RIGHT_BOTTOM;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.RIGHT_CENTER;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.RIGHT_TOP;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.TOP_CENTER;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.TOP_LEFT;
import static com.manu.mpopupwindow.widget.MPopupWindow.LocationType.TOP_RIGHT;

/**
 * @author: jzman
 * @time: 2018/6/5 0005 13:59
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnTopLeft)
    Button btnTopLeft;
    @BindView(R.id.btnTopRight)
    Button btnTopRight;
    @BindView(R.id.btnBottomLeft)
    Button btnBottomLeft;
    @BindView(R.id.btnBottomRight)
    Button btnBottomRight;
    @BindView(R.id.btnLeftTop)
    Button btnLeftTop;
    @BindView(R.id.btnLeftBottom)
    Button btnLeftBottom;
    @BindView(R.id.btnRightTop)
    Button btnRightTop;
    @BindView(R.id.btnRightBottom)
    Button btnRightBottom;
    @BindView(R.id.btnTarget)
    Button btnTarget;
    @BindView(R.id.btnFromBottom)
    Button btnFromBottom;
    @BindView(R.id.btnFromTop)
    Button btnFromTop;
    @BindView(R.id.btnTopCenter)
    Button btnTopCenter;
    @BindView(R.id.btnBottomCenter)
    Button btnBottomCenter;
    @BindView(R.id.btnLeftCenter)
    Button btnLeftCenter;
    @BindView(R.id.btnRightCenter)
    Button btnRightCenter;

    View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_sample);
        ButterKnife.bind(this);
        contentView = LayoutInflater.from(this).inflate(R.layout.popup_window_layout, null);
    }

    @OnClick({R.id.btnTopLeft, R.id.btnTopRight, R.id.btnBottomLeft, R.id.btnBottomRight,
            R.id.btnLeftTop, R.id.btnLeftBottom, R.id.btnRightTop, R.id.btnRightBottom,
            R.id.btnFromBottom, R.id.btnFromTop, R.id.btnTopCenter, R.id.btnBottomCenter,
            R.id.btnLeftCenter, R.id.btnRightCenter, R.id.btnTarget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnTopLeft:
                showPopupWindow(TOP_LEFT);
                break;
            case R.id.btnTopRight:
                showPopupWindow(TOP_RIGHT);
                break;
            case R.id.btnTopCenter:
                showPopupWindow(TOP_CENTER);
                break;

            case R.id.btnBottomLeft:
                showPopupWindow(BOTTOM_LEFT);
                break;
            case R.id.btnBottomRight:
                showPopupWindow(BOTTOM_RIGHT);
                break;
            case R.id.btnBottomCenter:
                showPopupWindow(BOTTOM_CENTER);
                break;

            case R.id.btnLeftTop:
                showPopupWindow(LEFT_TOP);
                break;
            case R.id.btnLeftBottom:
                showPopupWindow(LEFT_BOTTOM);
                break;
            case R.id.btnLeftCenter:
                showPopupWindow(LEFT_CENTER);
                break;

            case R.id.btnRightTop:
                showPopupWindow(RIGHT_TOP);
                break;
            case R.id.btnRightBottom:
                showPopupWindow(RIGHT_BOTTOM);
                break;
            case R.id.btnRightCenter:
                showPopupWindow(RIGHT_CENTER);
                break;

            case R.id.btnFromBottom:
                showPopupWindowAtBottom(FROM_BOTTOM);
                break;

            case R.id.btnTarget:
                showOriginPopupWindow();
                break;
        }
    }

    private void showPopupWindow(MPopupWindow.LocationType type) {
        MPopupWindow popupWindow = new MPopupWindow
                .Builder(this)
                .setLayoutId(R.layout.popup_window_layout)
                .setBackgroundDrawable(new ColorDrawable(Color.GRAY))
                .setAnimationStyle(R.style.PopupWindowScaleTheme)
                .setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        Toast.makeText(MainActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        popupWindow.showPopupWindow(btnTarget, type);
    }

    private void showPopupWindowAtBottom(MPopupWindow.LocationType type) {
        MPopupWindow popupWindow = new MPopupWindow
                .Builder(this)
                .setLayoutId(R.layout.popup_window_layout)
                .setBackgroundDrawable(new ColorDrawable(Color.GRAY))
                .setWidth(WindowManager.LayoutParams.MATCH_PARENT)
                .setAnimationStyle(R.style.PopupWindowTranslateThemeFromBottom)
                .setGravity(Gravity.BOTTOM)
                .setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        Toast.makeText(MainActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        popupWindow.showPopupWindow(btnTarget, type);
    }

    private void showOriginPopupWindow() {
        contentView.findViewById(R.id.tvCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "相机", Toast.LENGTH_SHORT).show();
            }
        });
        contentView.findViewById(R.id.tvPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
            }
        });

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
        window.setAnimationStyle(R.style.PopupWindowTranslateThemeFromBottom);
        window.showAtLocation(btnTarget, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
}
