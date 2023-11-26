import java.util.HashMap;
import java.util.Map;

public class Striker extends Player{
    protected Striker(Builder builder) {
        super(builder);
    }

    @Override
    public Map<String, Stat> calculatePositionBonus(Position squadPosition) {
        Map<String,Stat> newStats = new HashMap<>(this.stats);
        if(squadPosition.equals(Position.STRIKER)) {
            newStats = applyBonus("Shooting", 10);
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
            return new Striker(this);
        }
    }
}
