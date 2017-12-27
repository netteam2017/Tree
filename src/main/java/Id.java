/**
 * Created by user on 29.11.2017.
 */
public class Id {
    private int height;
    private int number;

    public Id(int height, int number) {
        this.height = height;
        this.number = number;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > -1)
            this.height = height;
        else
            throw new IndexOutOfBoundsException(" height is negative ");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > -1) {
            this.number = number;
        } else {
            throw new IndexOutOfBoundsException(" number is negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        if (height != id.height) return false;
        return number == id.number;

    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Id{" +
                "height=" + height +
                ", number=" + number +
                '}';
    }
}
