package com.manu.mpopupwindow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.manu.mpopupwindow.databinding.ActivityMainBinding
/**
 * @Desc: MainActivity
 * @Author: jzman
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mTarget: View
    private lateinit var mContentView: View
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mTarget = findViewById(R.id.ivTarget)
        mContentView = LayoutInflater.from(this).inflate(R.layout.popup_window_layout, null)
        binding.btnTopLeft.setOnClickListener(this)
        binding.btnTopCenter.setOnClickListener(this)
        binding.btnTopRight.setOnClickListener(this)
        binding.btnCenter.setOnClickListener(this)
        binding.btnCenterLeftTop.setOnClickListener(this)
        binding.btnCenterLeftBottom.setOnClickListener(this)
        binding.btnCenterRightTop.setOnClickListener(this)
        binding.btnCenterRightBottom.setOnClickListener(this)
        binding.btnBottonLeft.setOnClickListener(this)
        binding.btnBottonCenter.setOnClickListener(this)
        binding.btnBottonRight.setOnClickListener(this)
        binding.btnFromTop.setOnClickListener(this)
        binding.btnFromBottom.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnTopLeft -> showPopupWindow(TypeGravity.TOP_LEFT)
            R.id.btnTopCenter -> showPopupWindow(TypeGravity.TOP_CENTER)
            R.id.btnTopRight -> showPopupWindow(TypeGravity.TOP_RIGHT)

            R.id.btnCenter -> showPopupWindow(TypeGravity.CENTER)
            R.id.btnCenterLeftTop -> showPopupWindow(TypeGravity.CENTER_LEFT_TOP)
            R.id.btnCenterLeftBottom -> showPopupWindow(TypeGravity.CENTER_LEFT_BOTTOM)
            R.id.btnCenterRightTop -> showPopupWindow(TypeGravity.CENTER_RIGHT_TOP)
            R.id.btnCenterRightBottom -> showPopupWindow(com.manu.mpopupwindow.TypeGravity.CENTER_RIGHT_BOTTOM)

            R.id.btnBottonLeft -> showPopupWindow(TypeGravity.BOTTOM_LEFT)
            R.id.btnBottonCenter -> showPopupWindow(TypeGravity.BOTTOM_CENTER)
            R.id.btnBottonRight -> showPopupWindow(TypeGravity.BOTTOM_RIGHT)

            R.id.btnFromTop -> showPopupWindow(TypeGravity.FROM_TOP)
            R.id.btnFromBottom -> showPopupWindow(TypeGravity.FROM_BOTTOM)
        }
    }

    /**
     * 封装后的使用方式
     */
    private fun showPopupWindow(gravity: Int) {
        MPopupWindow.create(this)
                .setLayoutId(R.layout.popup_window_layout)
                .setBackgroundDrawable(ColorDrawable(Color.GREEN))
                .setAnimationStyle(R.style.PopupWindowScaleTheme)
                .setOnDismissListener {}
                .setTarget(mTarget)
                .setGravity(gravity)
                .build()
                .show()
    }

    /**
     * 原来的使用方式
     */
    private fun showOriginPopupWindow() {
        mContentView.findViewById<View>(R.id.tvCamera).setOnClickListener { Toast.makeText(this@MainActivity, "相机", Toast.LENGTH_SHORT).show() }
        mContentView.findViewById<View>(R.id.tvPhoto).setOnClickListener { Toast.makeText(this@MainActivity, "相册", Toast.LENGTH_SHORT).show() }
        //创建PopupWindow
        val window = PopupWindow(this)
        //设置显示View
        window.contentView = mContentView
        //设置宽高
        window.width = WindowManager.LayoutParams.MATCH_PARENT
        window.height = WindowManager.LayoutParams.WRAP_CONTENT
        //设置背景
        window.setBackgroundDrawable(ColorDrawable(Color.GRAY))
        //设置PopupWindow之外的触摸事件
        window.isOutsideTouchable = true
        //设置PopupWindow消失的监听器
        window.setOnDismissListener {
            //监听PopupWindow的消失
        }
        //设置PopupWindow上的触摸事件
        window.isTouchable = true
        //设置PopupWindow弹出动画
        window.animationStyle = R.style.PopupWindowTranslateThemeFromBottom
        window.showAtLocation(mTarget, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
    }
}