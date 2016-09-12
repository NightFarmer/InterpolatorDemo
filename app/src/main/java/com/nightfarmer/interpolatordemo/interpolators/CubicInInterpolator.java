package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/2.
 */

public class CubicInInterpolator implements Interpolator {
	
    public CubicInInterpolator() {}
	
    public CubicInInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return input * input * input;
	}
}
