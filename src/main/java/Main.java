import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
   public static StringBuilder  str = new StringBuilder("[");



    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatter2= new SimpleDateFormat("_yyyy-MM-dd_'at'_HH.mm.ss_z_");
        Date dateStart = new Date(System.currentTimeMillis());
        String dateStartStr = formatter2.format(dateStart);
        File file = new File("report"+dateStartStr+".json");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
       // writer.write(report);
        //writer.flush();











        while (1==1){
           // RegExp.getResult(HttpRequest.sendGet("w"));
          //  JsonWorker.jsonBuilder(JsonWorker.read(),"moscov","20-05-2022");
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            Calendar instance = Calendar.getInstance();
            instance.setTime(date); //устанавливаем дату, с которой будет производить операции
            //System.out.println(formatter.format(date));

            int dayCount = 2;
            int c = 0;
            while (c<dayCount) {
                c++;
                String dateStr = formatter.format(date);
                int offset = 0;
                while (true) {


                    String json = HttpRequest.sendGet(Integer.toString(offset), dateStr);
                    if (JsonWorker.jsonBuilder(json, "MSK", dateStr)) {
                        offset = offset + 20;
                    } else {
                        break;
                    }
                    Thread.sleep(3000);


                }

                instance.add(Calendar.DAY_OF_MONTH, 1);// прибавляем 3 дня к установленной дате
                date = instance.getTime(); // получаем измененную дату
                dateStr = formatter.format(date);
                System.out.println(dateStr);
                Thread.sleep(12000);
            }
            str.setLength(str.length() - 1);
            str.append("\n]");
            String report = str.toString();
            writer.write(report);
            writer.flush();
            Thread.sleep(120000);
        }


    }
}
