/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacaalc.miniGameFramework;

import com.mojang.brigadier.CommandDispatcher;
import static dev.jorel.commandapi.Brigadier.getCommandDispatcher;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.BooleanArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import java.util.HashMap;
import static org.bukkit.Bukkit.getConsoleSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author waca
 */
public class PluginMain extends JavaPlugin{

    
    HashMap<String,SuperFish> sflist = new HashMap<String,SuperFish>();
    
    @Override
    public void onLoad(){
        
        
        
        /*
        Start
        */
        new CommandAPICommand("start")
            .withArguments(new StringArgument("gamename"), new StringArgument("mapname"))
            .executes((sender, args) -> {
                //         
                getLogger().info("start called");
                
                String gamename = (String) args[0];
                
                if(!sflist.containsKey(gamename)){
                    sflist.put(gamename, new SuperFish());
                }
                
                //func init
 
                    getServer().dispatchCommand(getConsoleSender(),"gameover a true");

                        
                //func init map
                
                /*
                while(!sflist.get(gamename).getGameover()){
                    //func loop
                    
                    
                    //func loop map
                }
                    */
                
                //func display result
                
                //func display result map
                
                //(delay)
                
                //func reset
                
                
                //func reset map
                
                
                
            })
            .register();
        
        
        /*
        Gameover
        */
        new CommandAPICommand("gameover")
            .withArguments(new StringArgument("gamename"),new BooleanArgument("boolean"))
            .executes((sender, args) -> {
                //         
                getLogger().info("gameover called");
                String gamename = (String) args[0];                
                sflist.get(gamename).setGameover((boolean) args[1]);
            })
            .register();        
        
        /*
        reset
        */
        new CommandAPICommand("reset")
            .withArguments(new StringArgument("gamename"))
            .executes((sender, args) -> {
                //         
                getLogger().info("reset called");
            })
            .register();              
    }
    
   
    /*
     * 起動時処理
     */
    @Override
    public void onEnable() {
        getLogger().info("miniGameFramework enabled");
       // getCommand("wcstart").setExecutor(new mgfCommandExecutor(this));
        //getServer().getPluginManager().registerEvents(new TestPluginEventListener(this), this);
    }

    /*
     * 終了時処理
     */
    @Override
    public void onDisable() {
        getLogger().info("miniGameFramework disabled");
    }
    
    
    
    /*
    * Legacy コマンド処理
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {    
        if(cmd.getName().equalsIgnoreCase("wcinit")){
            
        }else if(cmd.getName().equalsIgnoreCase("wcstart")){
            
        }else if(cmd.getName().equalsIgnoreCase("wcend")){
            
        }else if(cmd.getName().equalsIgnoreCase("wcreset")){
            
        }
        
        
        
        return false;
    }
    */

    
}
