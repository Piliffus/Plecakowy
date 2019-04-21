public class Price
{
    int value;

    public int getValue()
    {
        return value;
    }

    public Price(int[] value)
    {
        this.value = value[0];
    }

    public Price(int value)
    {
        this.value = value;
    }
}
