package Chapter_01;

public class Apple {

    private Integer weight;

    private String variety;

    private String color;

    public Apple() {
    }

    public Apple(Integer weight, String variety, String color) {
        this.weight = weight;
        this.variety = variety;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", variety='" + variety + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
