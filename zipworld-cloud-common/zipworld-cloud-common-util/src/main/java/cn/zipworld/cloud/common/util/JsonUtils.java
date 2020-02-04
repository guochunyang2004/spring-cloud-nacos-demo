package cn.zipworld.cloud.common.util;


import com.google.gson.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtils {
    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(obj);
    }

    public static <T> T toEntity(String json, Class<T> cls) {
        Gson gson = new Gson();
        return gson.fromJson(json, cls);
    }
    //不带泛型的json转list
// gson.fromJson(json, new TypeToken<List<YourClass>>() {}.getType());
    public static <T> List<T> toListObj(String json, Class<T> cls) {
        List reList = new ArrayList();
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonArray array = jsonElement.getAsJsonArray();
        Iterator iterator = array.iterator();
        Gson gson = new Gson();

        while (iterator.hasNext()) {
            JsonElement json2 = (JsonElement) iterator.next();
            T contact = gson.fromJson(json2, cls);
            //can set some values in contact, if required
            reList.add(contact);
        }

        return reList;
    }

}
