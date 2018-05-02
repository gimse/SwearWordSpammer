package no.gimse.haakon.cuntspammer;


import java.util.TimerTask;


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
