public class Length
{
    int value;

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

    public Length(int[] value)
    {
        this.value = value[0];
    }

    public Length(int value)
    {
        this.value = value;
    }
}
