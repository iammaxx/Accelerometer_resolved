package com.accelerometer_resolved;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Launcher extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor accel;
    TextView X;
    TextView Y;
    TextView Z;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        X=(TextView)findViewById(R.id.ax);
        Y=(TextView)findViewById(R.id.ay);
        Z=(TextView)findViewById(R.id.az);

        a=0;
        x=a;
        y=a;
        z=a;
        j=0;
    }
    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);
    }
    float a;
    int j;
    Float x,y,z;
    @Override
    public void onSensorChanged(SensorEvent event) {
//        Toast.makeText(this, "Change", Toast.LENGTH_SHORT).show();
        if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE)
        {


                x += event.values[0];
                y += event.values[1];
                z += event.values[2];
                i++;


            Log.d("VAL",event.values.toString());

            if(i==100){
                x/=10;

                y/=10;
                z/=10;

            X.setText(x.toString());
            Y.setText(y.toString());
            Z.setText(z.toString());
            i=0;
                x=a;
                y=a;
                z=a;
    }

    }}

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
