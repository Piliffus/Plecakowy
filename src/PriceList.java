import java.util.Arrays;

public class PriceList
{
    private int size;
    private Rod[] rods;

    private void setRods()
    {
        for (int i = 0; i < size; i++)
        {
            rods[i] = new Rod(Input.getNumber(Rod.howManyFields()));
        }
    }

    public void sortRodsByLengthReverseOrder()
    {
        sortRodsByLength();
        reverseRods();
    }

    public void sortRodsByLength()
    {
        Arrays.sort(rods, 0, size);
    }

    private void reverseRods()
    {
        for (int i = 0, j = size-1; i <= (size-1) / 2; i++, j--)
        {
            Rod helper = rods[i];
            rods[i] = rods[j];
            rods[j] = helper;
        }
    }

    public Rod[] getRods()
    {
        return rods;
    }

    public int getSize()
    {
        return size;
    }

    public PriceList(int size)
    {
        this.rods = new Rod[size];
        this.size = size;
        setRods();
    }
}
