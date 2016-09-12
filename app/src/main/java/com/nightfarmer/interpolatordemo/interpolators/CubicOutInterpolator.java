package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/2.
 */

public class CubicOutInterpolator implements Interpolator {
	
    public CubicOutInterpolator() {}
	
    public CubicOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (input - 1) * (input - 1) * (input - 1) + 1;
	}
}
