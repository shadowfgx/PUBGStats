package com.example.pubg.model;

import java.math.BigDecimal;

public class PlayerStatics {

    String nickname;
    String gameMode;
    String tier;
    String subTier;
    int currentRankPoint;
    int roundsPlayed;
    float avgRank;
    float top10Ratio;
    float winRatio;
    int assists;
    int wins;
    BigDecimal kda;
    int kills;
    int deaths;

    public PlayerStatics(String nickname, String gameMode, String tier, String subTier, int currentRankPoint, int roundsPlayed, float avgRank, float top10Ratio, float winRatio, int assists, int wins, BigDecimal kda, int kills, int deaths) {
        this.nickname = nickname;
        this.gameMode = gameMode;
        this.tier = tier;
        this.subTier = subTier;
        this.currentRankPoint = currentRankPoint;
        this.roundsPlayed = roundsPlayed;
        this.avgRank = avgRank;
        this.top10Ratio = top10Ratio;
        this.winRatio = winRatio;
        this.assists = assists;
        this.wins = wins;
        this.kda = kda;
        this.kills = kills;
        this.deaths = deaths;
    }

    public PlayerStatics() {
        nickname = "";
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getSubTier() {
        return subTier;
    }

    public void setSubTier(String subTier) {
        this.subTier = subTier;
    }

    public int getCurrentRankPoint() {
        return currentRankPoint;
    }

    public void setCurrentRankPoint(int currentRankPoint) {
        this.currentRankPoint = currentRankPoint;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public float getAvgRank() {
        return avgRank;
    }

    public void setAvgRank(float avgRank) {
        this.avgRank = avgRank;
    }

    public float getTop10Ratio() {
        return top10Ratio;
    }

    public void setTop10Ratio(float top10Ratio) {
        this.top10Ratio = top10Ratio;
    }

    public float getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(float winRatio) {
        this.winRatio = winRatio;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public BigDecimal getKda() {
        return kda;
    }

    public void setKda(BigDecimal kda) {
        this.kda = kda;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "PlayerStatics{" +
                "nickname='" + nickname + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", tier='" + tier + '\'' +
                ", subTier='" + subTier + '\'' +
                ", currentRankPoint=" + currentRankPoint +
                ", roundsPlayed=" + roundsPlayed +
                ", avgRank=" + avgRank +
                ", top10Ratio=" + top10Ratio +
                ", winRatio=" + winRatio +
                ", assists=" + assists +
                ", wins=" + wins +
                ", kda=" + kda +
                ", kills=" + kills +
                ", deaths=" + deaths +
                '}';
    }
}
