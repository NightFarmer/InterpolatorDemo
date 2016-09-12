package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/**
 * Created by cimi on 15/7/3.
 */

public class QuadInInterpolator implements Interpolator {

	public QuadInInterpolator() {}

    public QuadInInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		return input * input;
	}
}
