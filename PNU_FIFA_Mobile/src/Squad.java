import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


//Position: STRIKER, Player:
public class Squad {
    private EnumMap<Position,Player> em = new EnumMap<>(Position.class);

    public void placePlayer(Position position, Player player) {
        em.put(position,player);

    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("Squad{\n");
        for(Position position : Position.values()){
            Player player = em.get(position);
            st.append(String.format("Position: %s, Player: %s, Stats with Bonus: %s\n",position,player,player.calculatePositionBonus(position)));
        }
        st.append("}\n");
        return st.toString();
    }
}

