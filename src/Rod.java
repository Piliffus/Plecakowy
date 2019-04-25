public class Rod implements Comparable<Rod>
{
    private Length length; // millimeters
    private Price price; // PLN

    @Override
    public int compareTo(Rod other) // Rods are compared by length
    {
        return this.length.getValue() - other.length.getValue();
    }

    @Override
    public String toString()
    {
        return "Rod{" +
                "length=" + length.getValue() +
                ", price=" + price.getValue() +
                '}';
    }

    public static int howManyFields()
    {
        return 2;
    }

    public Length getLength()
    {
        return length;
    }

    public Price getPrice()
    {
        return price;
    }

    public Rod(int[] argument)
    {
        this.length = new Length(argument[0]);
        this.price = new Price(argument[1]);
    }
}
