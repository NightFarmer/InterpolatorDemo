package com.nightfarmer.interpolatordemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

import com.nightfarmer.interpolatordemo.interpolators.MathConstants;


/**
 * Created by cimi on 15/7/3.
 */


public class ElasticOutInterpolator implements Interpolator {

    /**
     * 振幅
     */
    public float swing = 1.2f;

    public float getInterpolation(float input) {
        if (input == 0) {
            return 0;
        }
        if (input == 1) {
            return 1;
        }
        return (float) (Math.pow(2, -10 * input) * Math.sin((input * swing - 0.26 / 4) * Math.PI * 2.0f / 0.3) + 1);
    }
}
