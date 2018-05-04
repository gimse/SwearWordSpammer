package no.gimse.haakon.cuntspammer;


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
public class MyTimerTask extends TimerTask{
    MainActivity main;
    IMessageCreator messageCreator;
    SendSms sender;
    public MyTimerTask(MainActivity main,IMessageCreator messageCreator,String phoneNumber){
        this.main=main;
        this.messageCreator=messageCreator;
        sender = new SendSms(phoneNumber,main);
    }

    public void run(){
        main.runOnUiThread(new Runnable() {
            public void run() {
                sender.sendSms(messageCreator.getMessage());

            }
        });

    }
}
