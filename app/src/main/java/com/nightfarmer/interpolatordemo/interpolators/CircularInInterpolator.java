package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/2.
 */

public class CircularInInterpolator implements Interpolator {
	
    public CircularInInterpolator() {}
	
    public CircularInInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (float) (-1 * (Math.sqrt(1 - input * input) - 1.0f));
	}
}
