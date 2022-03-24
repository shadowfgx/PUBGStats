package com.example.pubg.controller;

import com.example.pubg.model.PlayerStatics;
import com.example.pubg.service.DataService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.math.BigDecimal;


@Controller
public class StaticsController {
    private final DataService dataService;
    private Logger logger = LoggerFactory.getLogger(StaticsController.class);

    @Autowired
    public StaticsController(DataService dataService) {
        this.dataService = dataService;
    }




    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showName(Model model, @RequestParam("nickname") String nickname,
                                        @RequestParam("season") String season) throws IOException {

        try {

            String idPlayer = dataService.getIdPlayer(nickname); // CON ESTA LLAMADA OBTENEMOS EL ID DEL PLAYER

            JSONObject statsRanked = dataService.getRankedStats(idPlayer, season);

            JSONObject statics = statsRanked.getJSONObject("data")
                    .getJSONObject("attributes").getJSONObject("rankedGameModeStats")
                    .getJSONObject("squad-fpp");

            logger.info("season: " + season);

            int kills = (Integer) statics.get("kills");

            PlayerStatics player = new PlayerStatics();

            player.setNickname(nickname);
            player.setKills((Integer) statics.get("kills"));
            player.setCurrentRankPoint((Integer) statics.get("currentRankPoint"));
            player.setAssists((Integer) statics.get("assists"));
            player.setKda((BigDecimal) statics.get("kda"));
            player.setTier(statics.getJSONObject("currentTier").get("tier").toString());
            player.setSubTier(statics.getJSONObject("currentTier").get("subTier").toString());
            player.setRoundsPlayed((Integer) statics.get("roundsPlayed"));
            player.setWins((Integer) statics.get("wins"));
            player.setDeaths((Integer) statics.get("deaths"));

            double deaths = player.getDeaths();
            double kd = (player.getKills() + player.getWins()) / deaths;
            double kda = player.getKda().doubleValue();
            logger.info(player.toString());
            model.addAttribute("player", player);
            model.addAttribute("kd", round(kd, 2));
            model.addAttribute("kda", round(kda, 2));
        }catch(Exception e){
                String badNick = "true";
                String gamesNotFound = "true";
                logger.info(e.toString());
                if(e.toString().contains("java.io.FileNotFoundException")){
                    model.addAttribute("badNick", badNick);
                }else if(e.toString().contains("org.json.JSONException")){
                    model.addAttribute("gamesNotFoud", gamesNotFound);
                }
                return "/index";

        }

        return "/stats";
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }


}
