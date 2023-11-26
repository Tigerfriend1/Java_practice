package com.fm.game;

import com.fm.repository.PlayerRepository;
import com.fm.repository.PlayerSearchPredicateFactory;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

//<검색조건>
//
//name:[선수명]
//
//        club:[클럽명]
//        nationality:[국가명]
//        position:[선수포지션] 선수포지션={ST, LW, RW, CM, LM, RM, CAM, LB, CB, RB, GK}
//        단, 선수명, 클럽명, 국가명은 일부만 일치해도 검색되지만, 선수 포지션은 문자열이 모두 일치해야 검색됨
//
//<명령어>
//
//search - 선수 리스트에서 검색조건에 맞는 선수들을 검색합니다.
//
//        quit - 프로그램을 종료합니다.

public class StreamTest {
    public static void main(String[] args) {
        PlayerRepository.getInstance().load();

        Scanner scanner = new Scanner(System.in);
        List<SearchCondition> searchConditions = new ArrayList<>();
        boolean success = false;
        while (scanner.hasNext()) {
            String option = scanner.nextLine();
            String[] params = option.split(":");
            switch (params[0]) {
                case "club":
                case "nationality":
                case "name":
                case "position":
                    success = searchConditions.add(new SearchCondition(params[0], params[1]));
                    break;
                case "search":
                    success = searchPlayer(searchConditions);
                    break;
                case "quit":
                default:
                    success = false;
            }
            if (!success) break;
        }
        scanner.close();
    }

    private static boolean searchPlayer(List<SearchCondition> searchConditions) {
        List<Predicate<Player>> conditions = PlayerSearchPredicateFactory.makeConditions(searchConditions);
        List<Player> result = PlayerRepository.getInstance().query(conditions);
        System.out.printf("%d - %s\n", result.size(), result);
        searchConditions.clear();
        return true;
    }
}
