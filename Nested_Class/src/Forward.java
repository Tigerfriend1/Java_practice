public class Forward extends Player{
    protected String playerType;
    public Forward(String name, int jerseyNumber, int speed) {
        super(name,jerseyNumber,speed);
        playerType="Forward";
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
        return speed+10;
    }
}
