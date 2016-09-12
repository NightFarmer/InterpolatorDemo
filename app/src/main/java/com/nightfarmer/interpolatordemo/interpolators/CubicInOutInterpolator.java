package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/2.
 */

public class CubicInOutInterpolator implements Interpolator {
	
    public CubicInOutInterpolator() {}
	
    public CubicInOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		if((input /= 0.5f) < 1) {
			return 0.5f * input * input * input;
		}
		return 0.5f * ((input -= 2) * input * input + 2);
	}
}
