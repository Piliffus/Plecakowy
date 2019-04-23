public class Length implements Comparable<Length>
{
    private int value;

    @Override
    public int compareTo(Length other)
    {
        return this.getValue() - other.getValue();
    }

    public static int howManyFields()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return "Length{" +
                "value=" + value +
                '}';
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public Length(int[] value)
    {
        this.value = value[0];
    }

    public Length(int value)
    {
        this.value = value;
    }
}
