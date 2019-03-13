package lt.vtvpmc.lt.ems.zp182.timer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private Chronometer myChronometer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myChronometer = (Chronometer) findViewById(R.id.myChronometer);
        myChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapseMillis = SystemClock.elapsedRealtime() - myChronometer.getBase();
                int h = (int) (elapseMillis / 3600000);
                int m = (int) (elapseMillis - h * 3600000) / 60000;
                int s = (int) (elapseMillis - h * 3600000 - m * 60000) / 1000;
                String timerTime = (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
                chronometer.setText(timerTime);
            }
        });

    }

    public void onStartClick(View view) {
        myChronometer.setBase(SystemClock.elapsedRealtime());
        myChronometer.setText("00:00:00");
        myChronometer.start();

    }

    public void onStopClick(View view) {
        myChronometer.stop();
    }

    public void onResetClick(View view) {
        myChronometer.setBase(SystemClock.elapsedRealtime());
    }
}
