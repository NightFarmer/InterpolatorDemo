package com.nightfarmer.interpolatordemo;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangfan on 16-9-12.
 */
public class InterpolatorAdapter extends RecyclerView.Adapter<InterpolatorAdapter.InterpolatorViewHolder> {

    private final InterpolatorLib[] interpolatorArray;

    public InterpolatorAdapter() {
        this.interpolatorArray = InterpolatorLib.values();
    }

    @Override
    public InterpolatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interpolator_item, parent, false);
        return new InterpolatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InterpolatorViewHolder holder, int position) {
        holder.interpolatorPreView.setInterpolator(interpolatorArray[position].getInterpolator());
        holder.tv_title.setText(interpolatorArray[position].toString());
    }

    @Override
    public int getItemCount() {
        return interpolatorArray.length;
    }

    public class InterpolatorViewHolder extends RecyclerView.ViewHolder {
        InterpolatorPreView interpolatorPreView;
        TextView tv_title;
        View dotView;

        public InterpolatorViewHolder(View itemView) {
            super(itemView);
            interpolatorPreView = (InterpolatorPreView) itemView.findViewById(R.id.interpolatorPreView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            dotView = itemView.findViewById(R.id.view_dot);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interpolatorPreView.startAnim();
                    dotView.setTranslationY(0);
                    float s = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, view.getContext().getResources().getDisplayMetrics());
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(dotView, "translationY", 0, s);
                    objectAnimator.setInterpolator(interpolatorPreView.getInterpolator());
                    objectAnimator.setStartDelay(500);
                    objectAnimator.setDuration(1000);
                    objectAnimator.start();
                }
            });
        }
    }

}
