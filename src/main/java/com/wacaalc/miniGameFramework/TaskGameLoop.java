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
    
    JavaPlugin plugin;
    SuperFish sf;
    TaskGameEnd tskend;
    
    TaskGameLoop(JavaPlugin plugin, SuperFish sf){
        this.plugin = plugin;
        this.sf = sf;
        tskend = new TaskGameEnd(plugin,sf);
    }
    
    @Override
    public void run(){
        if(!sf.getGameover()){
            //func gameloop
            plugin.getServer().dispatchCommand(getConsoleSender(),"say b");
            new TaskGameLoop(plugin,sf).runTaskLater(plugin,1);
        }else{
            
            //display result
            plugin.getServer().dispatchCommand(getConsoleSender(),"say c");            
            //func reset
            tskend.runTaskLater(plugin,100);
        }
    }
}
