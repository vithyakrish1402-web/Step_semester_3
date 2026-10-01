package abstract_interfaces.class_problems;

public abstract class KitchenTool {

    private int speedLevel = 1;

    public KitchenTool() {
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
    }

    public abstract String prepare();
}
