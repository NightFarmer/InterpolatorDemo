package com.nightfarmer.interpolatordemo;

import android.view.animation.Interpolator;

/**
 * Created by zhangfan on 16-9-12.
 */
public class PowerInInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {
        return input * input;
    }
}
