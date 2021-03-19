/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacaalc.miniGameFramework;

import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;

/**
 *
 * @author waca
 */
public class GameController {
    
 private PluginMain plugin;
 private String gamename;
 private String mapname;
 private boolean gameover = false;
 private boolean isRunning;
 
 
 public int time = 0;
 public int timemax = 0;
 public KeyedBossBar timer;
 public NamespacedKey key;
 
 void setGameover(boolean b){
     gameover = b;
 }
 
 boolean getGameover(){
     return gameover;
 }
 
  void setIsRunning(boolean b){
     isRunning = b;
 }
 
 boolean getIsRunning(){
     return isRunning;
 }
 
 
 GameController(String gamename, String mapname, PluginMain plugin){
     this.gamename = gamename;
     this.mapname = mapname;
     this.plugin  = plugin;
     this.key = new NamespacedKey(this.plugin, gamename);
     
     timer = plugin.getServer().createBossBar(key,gamename, BarColor.BLUE, BarStyle.SOLID);
     for(Player player: plugin.getServer().getOnlinePlayers()){
        timer.addPlayer(player);
     }
 }
 
 String getGamename(){
     return this.gamename;
 }
 
 String getMapname(){
     return this.mapname;
 } 
 
}
