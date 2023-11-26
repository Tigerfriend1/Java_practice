package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFactory {
    //L. Messi,170,Argentina,FC Barcelona,94,"RW, CF, ST"
    public static Player createPlayersWithoutID(String[] fields){
        String name = fields[0].trim();
        int height = Integer.parseInt(fields[1].trim());
        String nationality = fields[2].trim();
        String club = fields[3].trim();
        int overall = Integer.parseInt(fields[4].trim());
        List<String> positions = new ArrayList<>();
        for(int i= 5; i<fields.length;i++){
            if(fields[i].charAt(0)=='\"'){
                positions.add(fields[i].substring(1).trim());
            } else if (fields[i].charAt(fields[i].length()-1)=='\"') {
                positions.add(fields[i].substring(0,fields[i].length()-1).trim());
            } else positions.add(fields[i].trim());
        }

        return new Player(name, height, nationality, club, overall, positions);
    }

//    public static Player createPlayers(String[] fields){
//        //your code here
//    }
}

