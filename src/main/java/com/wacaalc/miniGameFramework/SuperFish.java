/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacaalc.miniGameFramework;

/**
 *
 * @author waca
 */
public class SuperFish {
 private String gamename;
 private String mapname;
 private int time = 0;
 private boolean gameover = false;
 
 void setGameover(boolean b){
     gameover = b;
 }
 
 boolean getGameover(){
     return gameover;
 }
 
}
