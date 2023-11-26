import java.util.HashMap;
import java.util.Map;

public class Midfielder extends Player{

    protected Midfielder(Builder builder) {
        super(builder);
    }

    @Override
    public Map<String, Stat> calculatePositionBonus(Position squadPosition) {
        Map<String,Stat> newStats = new HashMap<>(this.stats);
        if(squadPosition.equals(Position.MIDFIELDER)) {
            newStats = applyBonus("Passing", 10);
        }
        return newStats;
    }

    public static class Builder extends Player.Builder<Builder> {
        public Builder() {}

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Player build() {
            return new Midfielder(this);
        }
    }
}
