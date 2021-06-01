package com.ju.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * 自定义Button，演示自定义属性的使用
 */
@SuppressLint("AppCompatCustomView")
public class CustomButton extends Button {

    private static final String TAG = "CustomButton";

    private static final int[] STATE_SET_CORNER = { R.attr.corner };

    private boolean mCorner;
    private int mCornerRadius;

    public CustomButton(Context context) {
        super(context, null, R.style.JuButtonStyle);
        Log.i(TAG, "CustomButton  11111: " + this);
        initView(context, null, R.style.JuButtonStyle);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.style.JuButtonStyle);
        Log.i(TAG, "CustomButton  22222: " + this);
        initView(context, attrs, R.style.JuButtonStyle);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "CustomButton  33333: " + this);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        if (context == null) {
            return;
        }

        Log.i(TAG, "attrs: " + attrs);
        Log.i(TAG, "defStyleAttr: " + defStyleAttr);

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.JuButton, defStyleAttr, 0);

        saveAttributeDataForStyleable(context, R.styleable.JuButton,
                attrs, ta, defStyleAttr, 0);

        ta.recycle();

        mCorner = context.getBoolean(R.styleable.JuButton_corner, mCorner);
        if (mCorner) {
            mCornerRadius = ta.getDimensionPixelOffset(
                    R.styleable.JuButton_cornerRadius, mCornerRadius);
        }

        Log.i(TAG, "ta: " + ta);
        Log.i(TAG, "mCorner: " + mCorner);
        Log.i(TAG, "mCornerRadius: " + mCornerRadius);

        ta.recycle();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] state;

        if (mCorner) {
            state = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(state, STATE_SET_CORNER);
        } else {
            state = super.onCreateDrawableState(extraSpace);
        }

        return state;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who);
    }
}
