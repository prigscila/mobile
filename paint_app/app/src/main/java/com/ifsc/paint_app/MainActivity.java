package com.ifsc.paint_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skydoves.colorpickerview.ActionMode;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    SimplePaint simplePaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);
    }

    public void openColorPicker(View view) {
        new ColorPickerDialog.Builder(this)
            .setTitle(getString(R.string.chooseColor))
            .setPreferenceName("MyColorPickerDialog")
            .setPositiveButton(getString(R.string.confirm),
                    new ColorEnvelopeListener() {
                        @Override
                        public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                            setLayoutColor(envelope);
                        }
                    })
            .setNegativeButton(getString(R.string.cancel),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
            .attachAlphaSlideBar(true) // the default value is true.
            .attachBrightnessSlideBar(true)  // the default value is true.
            .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
            .show();
    }

    private void setLayoutColor(ColorEnvelope envelope) {
        simplePaint.setColorPaint(envelope.getColor());
    }

    public void clearDraw(View view) {
        simplePaint.clearDrawing();
    }

    public void useLine(View view) {
        simplePaint.useLine();
    }

    public void useSquare(View view) {
        simplePaint.useSquare();
    }

    public void useCircle(View view) {
        simplePaint.useCircle();
    }
}