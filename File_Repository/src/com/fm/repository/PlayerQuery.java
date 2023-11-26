package com.fm.repository;

import com.fm.unit.Player;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions){
        return players.stream()
                .filter(player -> conditions.stream().allMatch(c->c.test(player)))//모든 조건을 만족하는 플레이어를 택함.
                .collect(Collectors.toList());


    }
}