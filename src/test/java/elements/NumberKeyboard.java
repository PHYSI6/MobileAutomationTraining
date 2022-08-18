package elements;

import drivers.LocalMobileDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.Map;

public class NumberKeyboard {

    public static void enterNumber(String number){
        Map<Character, AndroidKey> mapKeys = Map.of
                ('0', AndroidKey.DIGIT_0,
                        '1', AndroidKey.DIGIT_1,
                        '2', AndroidKey.DIGIT_2,
                        '3', AndroidKey.DIGIT_3,
                        '4', AndroidKey.DIGIT_4,
                        '5', AndroidKey.DIGIT_5,
                        '6', AndroidKey.DIGIT_6,
                        '7', AndroidKey.DIGIT_7,
                        '8', AndroidKey.DIGIT_8,
                        '9', AndroidKey.DIGIT_9
                );

        for(int i = 0;i < number.length(); i++){
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                LocalMobileDriver.getDriver().pressKey(new KeyEvent(mapKeys.get(number.charAt(i))));
            }
        }
    }
}
