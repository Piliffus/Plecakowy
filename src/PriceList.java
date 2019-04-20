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

    public PriceList(int size)
    {
        this.rods = new Rod[size];
        this.size = size;
        setRods();
    }

    public Rod[] getRods()
    {
        return rods;
    }
}
