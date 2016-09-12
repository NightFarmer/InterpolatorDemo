package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/3.
 */

public class SineInInterpolator implements Interpolator {

	public SineInInterpolator() {}

    public SineInInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (float) (-1 * Math.cos(input * MathConstants._HALF_PI) + 1);
	}
}
