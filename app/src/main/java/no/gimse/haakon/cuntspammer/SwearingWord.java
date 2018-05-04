package no.gimse.haakon.cuntspammer;

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
