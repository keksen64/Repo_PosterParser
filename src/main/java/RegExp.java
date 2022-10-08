

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void getResult(String resp){
        Pattern pattern = Pattern.compile("class=\"PriceBlock(.*?)</h2>");
        Matcher matcher = pattern.matcher(resp);
        String[] arrayString =new String[100];
        int count = -1;
        while (matcher.find()) {
            count++;
            int start=matcher.start();
            int end=matcher.end();
            arrayString[count]= resp.substring(start,end);
            System.out.println("Найдено совпадение " + resp.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }

        Pattern pattern0 = Pattern.compile("\">(.*?)</span>");
        Pattern pattern1 = Pattern.compile("class=\"Title(.+?)</h2>");

        int count1 = 0;
        String[] resultArrayString =new String[100];
        while (count1 <= count){
            Matcher matcher0 = pattern0.matcher(arrayString[count1]);
            Matcher matcher1 = pattern1.matcher(arrayString[count1]);

            try {
                matcher0.find();
                matcher1.find();
                //      matcher2.find();
                int start0=matcher0.start();
                int end0=matcher0.end();
                int start1=matcher1.start();
                int end1=matcher1.end();

                resultArrayString[count1] = arrayString[count1].substring(start0,end0) +
                        "||" + arrayString[count1].substring(start1,end1);

                System.out.println("Найдено совпадение " + resultArrayString[count1]);
                count1 ++;
            }catch (Exception e){
                break;
            }

        }
    }










}
