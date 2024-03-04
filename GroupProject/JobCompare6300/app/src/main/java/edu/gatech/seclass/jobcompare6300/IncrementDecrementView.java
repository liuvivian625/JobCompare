package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.gatech.seclass.jobcompare6300.R;

public class IncrementDecrementView extends LinearLayout {

    private TextView valueTextView;
    private int value = 0;

    public IncrementDecrementView(Context context) {
        super(context);
        init(context);
    }

    public IncrementDecrementView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IncrementDecrementView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.increment_decrement_layout, this, true);
        Button incrementButton = view.findViewById(R.id.incrementButton);
        Button decrementButton = view.findViewById(R.id.decrementButton);
        valueTextView = view.findViewById(R.id.valueTextView);

        incrementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                updateValue();
            }
        });

        decrementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value > 0) {
                    value--;
                    updateValue();
                }
            }
        });
    }

    private void updateValue() {
        valueTextView.setText(String.valueOf(value));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        updateValue();
    }
}
