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
public class TaskGameLoop extends BukkitRunnable{
    
    PluginMain plugin;
    GameController gc;
    
    TaskGameLoop(PluginMain plugin, GameController gc){
        this.plugin = plugin;
        this.gc = gc;
    }
    
    @Override
    public void run(){
        
        if(gc.getIsRunning()==true && gc.getGameover()==false){
            //func gameloop
            plugin.getServer().dispatchCommand(getConsoleSender(),"say b");
            new TaskGameLoop(plugin,gc).runTaskLater(plugin,1);
        }else if(gc.getIsRunning()==true && gc.getGameover()==true){
            
            //display result
            plugin.getServer().dispatchCommand(getConsoleSender(),"say c");            
            //func reset
            new TaskGameEnd(plugin,gc).runTaskLater(plugin,100);
        }
    }
}
