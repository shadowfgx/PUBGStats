package com.example.pubg.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public interface DataService {

    JSONObject getJsonFromNickName(String nickName) throws IOException;
    String getIdPlayer(String nickname) throws IOException;
    String getNamePlayer() throws IOException;
    JSONObject getRankedStats(String id, String season) throws IOException;

}
