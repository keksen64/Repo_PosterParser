import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.jayway.jsonpath.internal.filter.ValueNode;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class JsonWorker {
    public static boolean jsonBuilder(String jsonString,String city, String date){
        /*

        //List<String> myList = new ArrayList<>();
        List<String> name1 = JsonPath.read(jsonString, "$.data[*].event.title");
        List<String> link1 = JsonPath.read(jsonString, "$.data[*].event.url");
        List<String> minCost1 = JsonPath.read(jsonString, "$.data[*].event.tickets[:1].price.min");
        List<String> maxCost1 = JsonPath.read(jsonString, "$.data[*].event.tickets[:1].price.max");
        List<String> theatre1 = JsonPath.read(jsonString, "$.data[*].scheduleInfo.onlyPlace.title");
        List<String> photo_name1 = JsonPath.read(jsonString, "$.data[*].event.image.sizes.eventCoverM2x.url");


        ValueNode.JsonNode jsonNode = JsonPath.parse(jsonString).read("$.data[:1]", ValueNode.JsonNode.class);
        if(jsonNode==null){
            System.out.println("хуй");
        }
        int l = name1.toArray().length;
//        System.out.println(friendsLastnames.toArray().length);
//        System.out.println(l1.toArray().length);
//        System.out.println(l2.toArray().length);
//        System.out.println(l3.toArray().length);

        Object[] name = Arrays.copyOf(name1.toArray(),name1.toArray().length);
        Object[] theatre = Arrays.copyOf(theatre1.toArray(),theatre1.toArray().length);
      //  Object[] text = Arrays.copyOf(l0.toArray(),l0.toArray().length);
        Object[] photo_name = Arrays.copyOf(photo_name1.toArray(),photo_name1.toArray().length);
        Object[] minCost = Arrays.copyOf(minCost1.toArray(),minCost1.toArray().length);
        Object[] maxCost = Arrays.copyOf(maxCost1.toArray(),maxCost1.toArray().length);
        Object[] link = Arrays.copyOf(link1.toArray(),link1.toArray().length);

        System.out.println(name.length);
        System.out.println(theatre.length);
        System.out.println(photo_name.length);
        System.out.println(minCost.length);
        System.out.println(maxCost.length);
        System.out.println(link.length);

        for (int c = 0;c<l; c++) {
            String json = "[{\"_id\": \"" + date + "_CIM_bes\",\n" +
                    "\"city\": \"" + sity + "\",\n";
            if(name[c]==null){
                json=json+ "\"name\": null,\n";
            }else{
                json=json+ "\"name\": \"" + name[c] + "\",\n";
            }
            if(theatre[c]==null){
                json=json+ "\"theatre\": null,\n";
            }else{
                json=json+ "\"theatre\": \"" + theatre[c] + "\",\n";
            }
            json=json+ "\"date\": {\"$date\": \"2022-05-15T00:00:00Z\"},\n";
            json=json+ "\"time\": \"00:00:00\",\n";
            json=json+ "\"text\": \"\",\n";
            if(photo_name[c]==null){
                json=json+ "\"photo_name\": null,\n";
            }else{
                json=json+ "\"photo_name\": \"" + photo_name[c] + "\",\n";
            }
            if(minCost[c]==null){
                json=json+ "\"minCost\": null,\n";
            }else{
                json=json+ "\"minCost\": " + minCost[c] + ",\n";
            }
            if(maxCost[c]==null){
                json=json+ "\"maxCost\": null,\n";
            }else{
                json=json+ "\"maxCost\": " + maxCost[c] + ",\n";
            }
            if(link[c]==null){
                json=json+ "\"link\": null,\n";
            }else{
                json=json+ "\"link\": \"" + link[c] + "\",\n";
            }
//            System.out.println("==========\n" + l0.toArray()[c].toString() + "\n" +
//                    l1.toArray()[c].toString() + "\n" +
//                    l2.toArray()[c].toString() + "\n" +
//                    l3.toArray()[c].toString());
            // executor(friendsLastnames.toArray()[1].toString());
            System.out.println(json+"\n====================================");
        }

        */









        ObjectMapper mapper = new ObjectMapper();
        boolean m = false;

        try {

            // convert JSON string to Map
            Map<String, Object> map = mapper.readValue(jsonString, Map.class);

            // it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

          //  System.out.println(map);
         //   Map<String, String> value = map.get("data");

      //      Iterator<String> iterator = map.keySet().iterator();

//            while(iterator.hasNext()){
//                Object key   = iterator.next();
//                System.out.println(key);
//            }
       //     Object value = map.get("paging");


            try {
                LinkedHashMap<String, Object> paging = (LinkedHashMap<String, Object>) map.get("paging");
                System.out.println(paging.get("offset"));
                System.out.println(paging.get("total"));
                if (Integer.parseInt(paging.get("offset").toString())<Integer.parseInt(paging.get("total").toString())){
                m = true;
                }
            }catch (Exception e){

            }


            ArrayList<String> data = (ArrayList<String>) map.get("data");
            int size = data.size();
            int i = 0;
            while (i<size) {
                String json = "\n{\n\"_id\": \"" + date + "_REPLACETRIGGERNAME_REPLACETRIGGERPLACE\",\n" +
                        "\"city\": \"" + city + "\",\n";



                Object ff = data.get(i);
                LinkedHashMap<String, Object> exemp = null;
                LinkedHashMap<String, Object> event = null;

                try {
                    exemp = (LinkedHashMap<String, Object>) ff;
                }catch (Exception e){
                    System.out.println("ОШИБКА ПОЛУЧЕНИЯ ЭКЗЕМПЛЯРА");
                }

                try {
                    event = (LinkedHashMap<String, Object>) exemp.get("event");
                }catch (Exception e){
                    System.out.println("ОШИБКА ПОЛУЧЕНИЯ СОБЫТИЯ");
                }

//                ArrayList<Object> tickets = (ArrayList<Object>) event.get("tickets");
//                LinkedHashMap<String, Object> price = (LinkedHashMap<String, Object>) tickets.get(0);
                //  System.out.println(price.get("price").getClass());
            //    System.out.println(price.get("price"));
             //   String priceS = price.get("price").toString();

//                Object oo = event.get("image");
//                LinkedHashMap<String, LinkedHashMap<String, Object>> image = (LinkedHashMap<String, LinkedHashMap<String, Object>>) oo;
              //  System.out.println(image.get("sizes").get("eventCoverM2x").getClass());
              //  System.out.println(image.get("sizes").get("eventCoverM2x"));
              //  String imageS = image.get("sizes").get("eventCoverM2x").toString();

                String theatre = null;
                try {
                    LinkedHashMap<String, Object> scheduleInfo = (LinkedHashMap<String, Object>) exemp.get("scheduleInfo");
                    LinkedHashMap<String, Object> onlyPlace = (LinkedHashMap<String, Object>) scheduleInfo.get("onlyPlace");
                  //  System.out.println(onlyPlace.get("title"));
                    theatre = onlyPlace.get("title").toString();
                }catch (Exception e){
                    try {
                        LinkedHashMap<String, Object> scheduleInfo = (LinkedHashMap<String, Object>) exemp.get("scheduleInfo");
                        LinkedHashMap<String, Object> oneOfPlaces = (LinkedHashMap<String, Object>) scheduleInfo.get("oneOfPlaces");
                  //      System.out.println(oneOfPlaces.get("title"));
                        theatre = oneOfPlaces.get("title").toString();
                    }catch (Exception ee){
                        theatre = "null";
                    }
                }





//                if(event.get("title")==null){
//                    json=json+ "\"name\": null,\n";
//                }else{
//                    json=json+ "\"name\": \"" + event.get("title").toString() + "\",\n";
//                }
//                if(theatre==null){
//                    json=json+ "\"theatre\": null,\n";
//                }else{
//                    json=json+ "\"theatre\": \"" + theatre + "\",\n";
//                }
//                json=json+ "\"date\": {\"$date\": \"2022-05-15T00:00:00Z\"},\n";
//                json=json+ "\"time\": \"00:00:00\",\n";
//                json=json+ "\"text\": \"\",\n";
//                if(image.get("sizes").get("eventCoverM2x")==null){
//                    json=json+ "\"photo_name\": null,\n";
//                }else{
//                    json=json+ "\"photo_name\": " + image.get("sizes").get("eventCoverM2x").toString() + ",\n";
//                }
//                if(price.get("price")==null){
//                    json=json+ "\"price\": null,\n";
//                }else{
//                    json=json+ "\"price\": " + price.get("price").toString() + ",\n";
//                }
//                if(event.get("url")==null){
//                    json=json+ "\"link\": null,\n";
//                }else{
//                    json=json+ "\"link\": \"https://afisha.yandex.ru" + event.get("url").toString() + "\"\n}]";
//                }


                String nameTitle = "null";
                String placeTitle = theatre;

                try {
                    json=json+ "\"name\": \"" + event.get("title").toString() + "\",\n";
                    nameTitle = event.get("title").toString();
                }catch (Exception e){
                    json=json+ "\"name\": null,\n";
                }
                try {
                    json=json+ "\"theatre\": \"" + theatre + "\",\n";
                }catch (Exception e){
                    json=json+ "\"theatre\": null,\n";
                }

                json=json+ "\"date\": {\"$date\": \""+date+"T00:00:00Z\"},\n";
                json=json+ "\"time\": \"00:00:00\",\n";
                json=json+ "\"text\": \"\",\n";
                try {

                    Object oo = event.get("image");
                    LinkedHashMap<String, LinkedHashMap<String, Object>> image = (LinkedHashMap<String, LinkedHashMap<String, Object>>) oo;
                    json=json+ "\"photo_name\": " + image.get("sizes").get("eventCoverM2x").toString() + ",\n";
                }catch (Exception e){
                    json=json+ "\"photo_name\": null,\n";
                }


                try {
                    ArrayList<Object> tickets = (ArrayList<Object>) event.get("tickets");
                    LinkedHashMap<String, Object> price = (LinkedHashMap<String, Object>) tickets.get(0);
                    json=json+ "\"price\": " + price.get("price").toString() + ",\n";
                }catch (Exception e){
                    json=json+ "\"price\": null,\n";
                }
                try {
                    json=json+ "\"link\": \"https://afisha.yandex.ru" + event.get("url").toString() + "\"\n},";
                }catch (Exception e){
                    json=json+ "\"link\": null,\n";
                }

                nameTitle = nameTitle.replace(' ', '_');
                placeTitle = placeTitle.replace(' ', '_');
                json=json.replace("REPLACETRIGGERNAME", nameTitle);
                json=json.replace("REPLACETRIGGERPLACE", placeTitle);





                System.out.println(json);
                Main.str.append(json);


                i++;
            }







        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
}





    public static void executor (String substr){
        System.out.println(substr);
        List<String> title = JsonPath.read(substr, "$.title[*]");
        System.out.println(title.toArray()[0]);
    }


    public static String read() throws IOException {
        Path path1 = Paths.get("X:/qqq/f1.txt");   //"X:/qqq/f1.txt"
        Scanner scan1 = new Scanner(path1);
        String str ="";
        while (scan1.hasNextLine()){
            str = str + scan1.nextLine();

        }
        return str;
    }
}


// class MT extends Thread{
//    public void run(){
//        ArrayList<Long> arrayList = new ArrayList<>();
//        for(int i = 0; i<100000; i++){
//            long k = System.currentTimeMillis()*i;
//            arrayList.add(k);
//            Collections.sort(arrayList);
//        }
//    }
//}


