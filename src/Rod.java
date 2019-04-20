public class Rod
{
    private Length length; // millimeters
    private Price price; // PLN

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

    @Override
    public String toString()
    {
        return "Rod{" +
                "length=" + length.value +
                ", price=" + price.value +
                '}';
    }

    public Rod(int[] argument)
    {
        this.length = new Length(argument[0]);
        this.price = new Price(argument[1]);
    }
}
