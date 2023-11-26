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
                case "name":predicateList.add(player -> player.getName().contains(searchCondition.getCondition())); break;
                case "club":predicateList.add(player -> player.getClub().contains(searchCondition.getCondition())); break;
                case "nationality":predicateList.add(player -> player.getNationality().contains(searchCondition.getCondition()));break;
                case "position" : predicateList.add(player -> player.getPositions().contains(searchCondition.getCondition()));break;
            }
        }
        return predicateList;

    }
}