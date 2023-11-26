package com.fm.repository;

import com.fm.unit.Player;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FileRepository implements IRepository{
    private static FileRepository instance = new FileRepository();
    boolean loaded = false;
    private List<Player> players;


    private FileRepository(){}

    public static FileRepository getInstance() {
        return instance;
    }

    public List<Player> load() {
        if (!isLoaded()) {
            List<Player> players = new ArrayList<>();
            Path FILENAME = Paths.get("players_20_short.csv");
            try (BufferedReader br = Files.newBufferedReader(FILENAME)) {
                String line;
                br.readLine(); // 첫 줄은 건너뛰기
                while ((line = br.readLine()) != null) {
                    Player p = createPlayer(line.split(","));
                    players.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            this.players = players;
            this.loaded = true; // 데이터가 로드되었음을 표시합니다.
        }
        return players;
    }


    public boolean isLoaded() {
        return loaded;
    }

    public List<Player> query(List<Predicate<Player>> conditions){
        if (0 < conditions.size() && 0 < players.size())
            return PlayerQuery.query(players, conditions);
        else
            return new ArrayList<>();
    }

    private Player createPlayer(String[] fields) {
        Player player = new Player(getId(fields), getName(fields), getHeight(fields),
                getNationality(fields), getClub(fields), getOverall(fields), getPosition(fields));
        return player;
    }

    private List<String> getPosition(String[] fields) {
        List<String> positions = new ArrayList<>();
        if (fields[Player.POSITION].startsWith("\"")) {
            for (int i = Player.POSITION; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[Player.POSITION]);
        }
        return positions;
    }

    private int getOverall(String[] arr) {
        return Integer.parseInt(arr[Player.OVERALL]);
    }

    private String getClub(String[] fields) {
        return fields[Player.CLUB];
    }

    private String getNationality(String[] fields) {
        return fields[Player.NATIONALITY];
    }

    private int getHeight(String[] fields) {
        return Integer.parseInt(fields[Player.HEIGHT]);
    }

    private String getName(String[] fields) {
        return fields[Player.NAME];
    }

    private int getId(String[] fields) {
        return Integer.parseInt(fields[Player.ID]);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Player t) {

    }

    @Override
    public void delete(Player t) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public Iterable<Player> findAll() {
        return null;
    }

    @Override
    public Optional<Player> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions) {
        return null;
    }
}
