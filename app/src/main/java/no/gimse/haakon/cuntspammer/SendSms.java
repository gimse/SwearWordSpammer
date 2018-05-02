package no.gimse.haakon.cuntspammer;

import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by lefdal on 11.09.2016.
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
