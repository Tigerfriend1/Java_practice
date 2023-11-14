public class Midfielder extends Player{
    protected String playerType;
    public Midfielder(String name, int jerseyNumber, int speed) {
        super(name,jerseyNumber,speed);
        playerType="Midfielder";
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder(super.toString());
        st.append("Speed=" + getSpeed() + ", ");
        st.append(playerType);
        return st.toString();
    }

    @Override
    protected int getSpeed() {
        return speed;
    }
}
