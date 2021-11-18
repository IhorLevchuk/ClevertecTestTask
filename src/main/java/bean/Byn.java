package bean;

import exeption.NonPositiveArgumentException;

public class Byn {
    private final int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Byn sub(Byn byn) {
        if (value < byn.value) {
            throw new NonPositiveArgumentException(value - byn.value);
        }
        return new Byn(value - byn.value);
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn mul(double value) {
        if (value < 0) {
            throw new NonPositiveArgumentException((int) value);
        }
        return new Byn((int) (this.value * value));
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }
}
