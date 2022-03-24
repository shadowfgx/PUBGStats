package com.example.pubg.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class DataServiceImpl implements DataService {

    @Override
    public JSONObject getJsonFromNickName(String nickname) throws IOException { //JsonArray estaba antes

        JSONObject responseJson = null;
        URL url = new URL("https://api.pubg.com/shards/steam/players?filter[playerNames]=" + nickname);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/vnd.api+json");
        http.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZDlmMDU1MC1kM2IzLTAxMzktZDkwYS01YmZmN2VjMTVjNzUiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNjI3Njg0MzE0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InN0YXRpY3NoYWRvdyJ9.odZfH6CNfnSj8n5QUMjza-GpFHFhniMruAIx612iUVU");

        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        responseJson = new JSONObject(sb.toString()); // Convertimos el StringBuilder en ObjectJson

        JSONArray arr = responseJson.getJSONArray("data"); // notice that `"posts": [...]`    //String pageName = obj.getJSONObject("data").getString("pageName");  ACCESSO A UN SOLO DATO

        return responseJson;   //DEBERIA DEVOLVER EL JSON Y LUEGO DE AHI DEVOLVER EL ID Y EL USERNAME

    }



    @Override
    public String getIdPlayer(String nickname) throws IOException {

        String id="";
        JSONObject responseJson = null;
        URL url = new URL("https://api.pubg.com/shards/steam/players?filter[playerNames]=" + nickname);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/vnd.api+json");
        http.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZDlmMDU1MC1kM2IzLTAxMzktZDkwYS01YmZmN2VjMTVjNzUiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNjI3Njg0MzE0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InN0YXRpY3NoYWRvdyJ9.odZfH6CNfnSj8n5QUMjza-GpFHFhniMruAIx612iUVU");

        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        responseJson = new JSONObject(sb.toString()); // Convertimos el StringBuilder en ObjectJson

        JSONArray arr = responseJson.getJSONArray("data"); // notice that `"posts": [...]`    //String pageName = obj.getJSONObject("data").getString("pageName");  ACCESSO A UN SOLO DATO

        for (int i = 0; i < arr.length(); i++) {    // ACCESO A UN DATO EN UNA COLECCION DE DATOS
            id = arr.getJSONObject(i).getString("id");
        }

        return id;   //DEBERIA DEVOLVER EL JSON Y LUEGO DE AHI DEVOLVER EL ID Y EL USERNAME
    }

    @Override
    public JSONObject getRankedStats(String id, String season) throws IOException {

        JSONObject responseJson = null;

        URL url = new URL("https://api.pubg.com/shards/steam/players/"+ id +"/seasons/division.bro.official.pc-2018-"+season+"/ranked");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/vnd.api+json");
        http.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZDlmMDU1MC1kM2IzLTAxMzktZDkwYS01YmZmN2VjMTVjNzUiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNjI3Njg0MzE0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InN0YXRpY3NoYWRvdyJ9.odZfH6CNfnSj8n5QUMjza-GpFHFhniMruAIx612iUVU");

        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }


        responseJson = new JSONObject(sb.toString());

        List<Object> list = new ArrayList<Object>(Collections.singleton(sb.toString()));


        return responseJson;
    }

    @Override
    public String getNamePlayer() throws IOException {
        String nickname = "shadowekko";
        String name="";
       // JSONArray arr = getJsonFromNickName(nickname);
        /*for (int i = 0; i < arr.length(); i++) {    // ACCESO A UN DATO EN UNA COLECCION DE DATOS
            name = arr.getJSONObject(i). .getString("name");
        } */
        return name;
    }
}
