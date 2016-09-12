package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/2.
 */

public class CircularOutInterpolator implements Interpolator {
	
    public CircularOutInterpolator() {}
	
    public CircularOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (float) (Math.sqrt(1 - (input - 1) * (input - 1)));
	}
}
