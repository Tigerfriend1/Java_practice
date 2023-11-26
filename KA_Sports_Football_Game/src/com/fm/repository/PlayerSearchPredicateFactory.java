package com.fm.repository;

import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerSearchPredicateFactory {
    //field, condition
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> predicateList = new ArrayList<>();
        for(SearchCondition searchCondition : searchConditions){
            switch (searchCondition.getField()){
                case "name"->predicateList.add(player -> player.getName().contains(searchCondition.getCondition()));
                case "club"->predicateList.add(player -> player.getClub().contains(searchCondition.getCondition()));
                case "nationality"->predicateList.add(player -> player.getNationality().contains(searchCondition.getCondition()));
                case "position" -> predicateList.add(player -> player.getPositions().equals(searchCondition.getCondition()));
            }
        }
        return predicateList;

    }
}
//searchConditions.stream().filter(p->p.