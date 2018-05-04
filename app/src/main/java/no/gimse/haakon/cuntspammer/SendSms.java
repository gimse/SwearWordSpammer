package no.gimse.haakon.cuntspammer;

import android.telephony.SmsManager;
import android.widget.Toast;

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
public class SendSms {
    String phoneNo;
    MainActivity main;
    public SendSms(String phoneNo, MainActivity main){
        this.phoneNo=phoneNo;
        this.main=main;
    }
    public boolean sendSms(String text){
        String sms = text;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, sms, null, null);
            Toast.makeText(main.getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_SHORT).show();
            return true;
        } catch (Exception e) {
                Toast.makeText(main.getApplicationContext(),
                        "SMS faild, please try again later!",
                        Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return false;
        }

    }
}
