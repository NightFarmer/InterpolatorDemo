package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/3.
 */

public class ExponentialOutInterpolator implements Interpolator {
	
    public ExponentialOutInterpolator() {}
	
    public ExponentialOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (float) ((input == 1) ? 1 : (-Math.pow(2, -10 * input) + 1));
	}
}
