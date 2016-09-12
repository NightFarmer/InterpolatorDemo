package com.nightfarmer.interpolatordemo.interpolators;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;


/**
 * Created by cimi on 15/7/3.
 */


public class ElasticOutInterpolator implements Interpolator {

	private float mDuration;
	
	/**
     * @param durationMillis Duration in milliseconds. The duration cannot be negative.
     *
     * @throws IllegalArgumentException if the duration is < 0
     *
     */
	public ElasticOutInterpolator(float durationMillis) {
		if (durationMillis < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
		mDuration = durationMillis / 1000f;
	}
	
    public ElasticOutInterpolator(Context context, AttributeSet attrs) {}

	public float getInterpolation(float input) {
		float s;
		float p;
		float a;
		if(input == 0) {
			return 0;
		}
		if(input == 1) {
			return 1;
		}
		p = mDuration * 0.3f;
		a = 1;
		s = p / 4;
		return (float) (a * Math.pow(2, -10 * input) * Math.sin((input * mDuration - s) * MathConstants._2PI / p) + 1 + 0);
	}
}
