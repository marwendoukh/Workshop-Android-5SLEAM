package tn.sleam.five.marwen.a5sleam.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import tn.sleam.five.marwen.a5sleam.R;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    // sensor
    private SensorManager mSensorManager;
    private Sensor maccelerometer;
    // TextViews
    private TextView xValue, yValue, zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        xValue = (TextView) findViewById(R.id.x_position_sensor);
        yValue = (TextView) findViewById(R.id.y_position_sensor);
        zValue = (TextView) findViewById(R.id.z_position_sensor);


        // setup the sensor
        mSensorManager = (SensorManager) getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
        maccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (maccelerometer != null) {
            // Success! There's a sensor.
            System.out.println("position : there is sensor ");
        } else {
            // Failure! No sensor.
            System.out.println("position : no sensor ");

        }
    }


    @Override
    public final void onSensorChanged(SensorEvent event) {
        xValue.setText("" + Math.round(event.values[0]));
        yValue.setText("" + Math.round(event.values[1]));
        zValue.setText("" + Math.round(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, maccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
