/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacaalc.miniGameFramework;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.BooleanArgument;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import java.util.HashMap;
import static org.bukkit.Bukkit.getConsoleSender;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author waca
 */
public class PluginMain extends JavaPlugin{

    
    private HashMap<String,GameController> gclist = new HashMap<String,GameController>();
    
    public void removeGC(String gamename){
        if(gclist.containsKey(gamename)){
            gclist.get(gamename).setIsRunning(false);
            gclist.get(gamename).timer.setVisible(false);
            getServer().removeBossBar(gclist.get(gamename).key);
            gclist.remove(gamename);
        }else{
            getLogger().info("There is not such a superfish tagged with "+ gamename);

        }
    } 
    
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
                String mapname  = (String) args[1];

                GameController gc = new GameController(gamename,mapname,this);
                gc.setIsRunning(true);
                
                if(!gclist.containsKey(gamename)){
                    gclist.put(gamename, gc);
                    
                    TaskGameLoop tsk = new TaskGameLoop(this,gclist.get(gamename));


                    //func init
                    getServer().dispatchCommand(getConsoleSender(),"say a");

                    //func init map
                    getServer().dispatchCommand(getConsoleSender(),"say a");

                    //Task
                    tsk.runTask(this);
                    
                }else{
                    getLogger().info("game has already started");
                }
                

                
                
            })
            .register();
        
        
 
        
        /*
        reset
        */
        new CommandAPICommand("reset")
            .withArguments(new StringArgument("gamename"))
            .withArguments(new StringArgument("mapname"))
            .executes((sender, args) -> {
                //         
                
                String gamename = (String) args[0];
                String mapname = (String) args[1];
                
                getLogger().info("reseting "+ gamename);

                //func reset
                getServer().dispatchCommand(getConsoleSender(),"say c"); 
                //func reset map
                getServer().dispatchCommand(getConsoleSender(),"say c"); 

                //remove SuperFish
                
                removeGC(gamename);
                
                
            })
            .register();           
        
        /*
        Gameover
        */
        new CommandAPICommand("gameover")
            .withArguments(new StringArgument("gamename"),new BooleanArgument("boolean"))
            .executes((sender, args) -> {
                //         
                
                String gamename = (String) args[0];                
                Boolean bool = (Boolean)args[1];
                
                getLogger().info("Assigning " +gamename+ "'s gameover = "+bool.toString());
                
                if(gclist.containsKey(gamename)){
                    gclist.get(gamename).setGameover((boolean) args[1]);
                }else{
                    getLogger().info("Game hasn't started yet");                    
                }
                                
            })
            .register();    
        
        /*
        Timer
        */
        new CommandAPICommand("timer")
            .withArguments(new StringArgument("gamename"),new StringArgument("set/add"),new IntegerArgument("value"))
            .executes((sender, args) -> {
                //         
                String gamename = (String) args[0];                
                String subcommand = (String) args[1];
                Integer value = (Integer) args[2];
                Integer hours;
                Integer mins;
                Integer secs;
                String title = gamename + ": ";
                
                
                if(gclist.containsKey(gamename)){

                    KeyedBossBar timer = gclist.get(gamename).timer;


                    switch(subcommand){
                        case "set":
                            gclist.get(gamename).timemax = value*20;
                            gclist.get(gamename).time = value*20;
                            
                            timer.setProgress(1.0);
                            break;
                        case "add":
                            gclist.get(gamename).time += value*20;
                            timer.setProgress(((double)gclist.get(gamename).time)/gclist.get(gamename).timemax);
                            break;
 
                        default:
                            getLogger().info("Invalid subcommand");
                            break;
                    }
                    
                    hours = gclist.get(gamename).time/(20*3600);
                    mins = gclist.get(gamename).time%(20*3600)/(20*60);
                    secs = gclist.get(gamename).time%(20*3600)%(20*60)/20;

                    if(hours!=0){
                        title += hours.toString()+":";
                    }

                    if(mins!=0){
                        title += mins.toString()+":";
                    }

                    title += secs.toString();



                    timer.setTitle(title);
                    timer.setVisible(true);
                    
                }else{
                    getLogger().info("Game hasn't started yet");
                }
                                                
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
    
    
    

    
}
