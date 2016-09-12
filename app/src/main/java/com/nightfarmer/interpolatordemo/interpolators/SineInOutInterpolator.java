package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/3.
 */

public class SineInOutInterpolator implements Interpolator {

	public SineInOutInterpolator() {}

    public SineInOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return (float) (-1 * 0.5f * (Math.cos(MathConstants.PI * input) - 1));
	}
}
