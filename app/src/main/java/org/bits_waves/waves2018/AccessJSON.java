package org.bits_waves.waves2018;

import android.content.Context;

import org.bits_waves.waves2018.ListItems.Event;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AccessJSON {

    public Event readEventJSON(Context context) {
        String jsonString = null;
        JSONObject jsonObject = new JSONObject();
        Event event = new Event();
        try{
            InputStream is = context.getAssets().open("Events.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
            jsonObject = new JSONObject(jsonString);
            event.setDescription(jsonObject.getString("description"));
            event.setName(jsonObject.getString("name"));
            event.setRules(jsonObject.getString("rules"));
            event.setImgRes(jsonObject.getString("imgres"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event;
    }

    public List<Event> readEventJSONArray(Context context) {
        String jsonString = null;
        Event event = new Event();
        List<Event> eventList = new ArrayList<>(0);
        JSONArray jsonArray = new JSONArray();
        try{
            InputStream is = context.getAssets().open("test.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
            jsonArray = new JSONArray(jsonString);
            while(!jsonArray.isNull(0)){

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<Event> readEventFromJSON(Context context) {
        String jsonString = null;
        List<Event> eventList = new ArrayList<>(0);
        try {
            InputStream is = context.getAssets().open("test.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
            //eventList = (List<Event>) J
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    /*private Context context;
    private FileInputStream fileIn;
    private FileOutputStream fileOut;
    private ObjectInputStream objectIn;
    private ObjectOutputStream objectOut;
    private Object outputObject;
    private String filePath;
    private List<String> stringListOut = new ArrayList<>();

    public AccessJSON(Context c){
        context = c;
    }

    public Object readObject(String fileName){
        try {
            filePath = context.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + fileName;
            fileIn = new FileInputStream(filePath);
            objectIn = new ObjectInputStream(fileIn);
            outputObject = objectIn.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectIn != null) {
                try {
                    objectIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return outputObject;
    }

    public void writeObject(Object inputObject, String fileName){
        try {
            filePath = context.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + fileName;
            fileOut = new FileOutputStream(filePath);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(inputObject);
            fileOut.getFD().sync();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOut != null) {
                try {
                    objectOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
