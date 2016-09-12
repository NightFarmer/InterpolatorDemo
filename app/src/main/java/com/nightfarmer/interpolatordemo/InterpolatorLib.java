package com.nightfarmer.interpolatordemo;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by zhangfan on 16-9-12.
 */
public enum InterpolatorLib {

    LinearInterpolator(new LinearInterpolator()),
    BounceInterpolator(new BounceInterpolator()),
    AccelerateInterpolator(new AccelerateInterpolator()),
    DecelerateInterpolator(new DecelerateInterpolator()),
    AccelerateDecelerateInterpolator(new AccelerateDecelerateInterpolator()),
    AnticipateInterpolator(new AnticipateInterpolator()),
    OvershootInterpolator(new OvershootInterpolator()),
    AnticipateOvershootInterpolator(new AnticipateOvershootInterpolator()),
    FastOutLinearInInterpolator(new FastOutLinearInInterpolator()),
    LinearOutSlowInInterpolator(new LinearOutSlowInInterpolator()),
    FastOutSlowInInterpolator(new FastOutSlowInInterpolator()),
    CycleInterpolator(new CycleInterpolator(0.5f)),
    ElasticOutInterpolator(new ElasticOutInterpolator()),
    PowerInInterpolator(new PowerInInterpolator()),
    PowerOutInterpolator(new PowerOutInterpolator()),
    PowerIn2Interpolator(new PowerIn2Interpolator());
//    PathInterpolator(new PathInterpolator()),

    private final Interpolator interpolator;

    public Interpolator getInterpolator() {
        return interpolator;
    }

    InterpolatorLib(Interpolator linearInterpolator) {
        this.interpolator = linearInterpolator;
    }
}
