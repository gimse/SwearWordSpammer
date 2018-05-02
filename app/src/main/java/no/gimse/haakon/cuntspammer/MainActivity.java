package no.gimse.haakon.cuntspammer;

import android.Manifest;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    TimerTask timerTask;
    boolean running;
    IMessageCreator messagecreator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        running=false;
        messagecreator=new SwearingWord(this.getResources());



    }
    public void start(View view){
        if(!running) {

            timer=new Timer();
            timerTask= new MyTimerTask(this,messagecreator,getNumber());
            timer.schedule(timerTask, 0, getDelay());
            running=true;
        }
    }
    public void stop(View view){
        if(running) {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
            running=false;
        }
    }
    public long getDelay(){
        try {
            EditText textView = (EditText) findViewById(R.id.interval);
            String text = String.valueOf(textView.getText());
            long number = Long.valueOf(text);
            return number*1000;
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),
                    "failed to get delay. Set to 1sek!",
                    Toast.LENGTH_LONG).show();

            e.printStackTrace();
            return 1000;
            }
    }
    public String getNumber(){
        EditText numberView = (EditText) findViewById(R.id.numberText);
        String text = String.valueOf(numberView.getText());
        return text;
    }


}
