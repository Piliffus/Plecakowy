public class Plan
{
    private Length[] lengths;
    private int size;

    private void setLengths()
    {
        for (int i = 0; i < size; i++)
        {
            lengths[i] = new Length(Input.getNumber(Length.howManyFields()));
        }
    }

    public Length[] getLengths()
    {
        return lengths;
    }

    public Plan(int size)
    {
        this.size = size;
        this.lengths = new Length[size];
        setLengths();
    }
}
