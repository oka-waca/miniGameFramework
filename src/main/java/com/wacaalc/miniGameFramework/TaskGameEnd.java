/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacaalc.miniGameFramework;

import static org.bukkit.Bukkit.getConsoleSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author waca
 */
public class TaskGameEnd extends BukkitRunnable{
    
    PluginMain plugin;
    GameController gc;
    
    TaskGameEnd(PluginMain plugin, GameController gc){
        this.plugin = plugin;
        this.gc = gc;
    }
    
    @Override
    public void run(){
       //reset func
       plugin.getServer().dispatchCommand(getConsoleSender(),"say d");
       //reset func map
       plugin.getServer().dispatchCommand(getConsoleSender(),"say d");
       
       //removeGC
       plugin.removeGC(gc.getGamename());
    }
    
    
}
