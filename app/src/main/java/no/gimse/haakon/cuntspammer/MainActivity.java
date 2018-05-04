
package no.gimse.haakon.cuntspammer;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
/**
 Copyright 2018 Hakon Gimse

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
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
