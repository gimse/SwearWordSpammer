package no.gimse.haakon.cuntspammer;

/**
 * Created by lefdal on 10.09.2016.
 */
import android.content.res.Resources;

import java.util.Random;

public class SwearingWord implements IMessageCreator {
    String[] words;
        Random random;
    public SwearingWord(Resources resources){
         words =resources.getStringArray(R.array.myarray);
        random = new Random();
    }
    @Override
    public String getMessage() {
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
