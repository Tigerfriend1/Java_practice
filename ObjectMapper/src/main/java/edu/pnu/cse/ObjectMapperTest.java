package edu.pnu.cse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class ObjectMapperTest {
    public static void main(final String... args) throws IOException {
        ObjectMapper obm = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        Player player = new Player(sc.nextInt(), sc.next());
        String responseBody = "";
        try {
            responseBody = obm.writeValueAsString(player);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        player = obm.readValue(responseBody,Player.class);
        System.out.println(player);
    }
}
