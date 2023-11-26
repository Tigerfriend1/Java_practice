import java.util.HashMap;
import java.util.Map;

//.addStat(new Stat("Defense", 92))
//.addStat(new Stat("Strength", 89))
public class Defender extends Player{
    protected Defender(Builder builder) {
        super(builder);

    }

    @Override
    public Map<String, Stat> calculatePositionBonus(Position squadPosition) {
        Map<String,Stat> newStats = new HashMap<>(this.stats);
        if(squadPosition.equals(Position.DEFENDER)){
            newStats=applyBonus("Defense", 10);
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
            return new Defender(this);
        }
    }

}
