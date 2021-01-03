package Students;

public class Mark {
    private double value;
    private double coefficient;

    public Mark() {
    }

    public Mark(double value, double coefficient) {
        this.value = value;
        this.coefficient = coefficient;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", coefficient=" + coefficient +
                '}';
    }
}
