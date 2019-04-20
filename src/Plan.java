public class Plan
{
    private Length[] lengths;
    private int size;

    private void setLengths()
    {
        int[] lengthValues = Input.getNumber(size);
        for (int i = 0; i < size; i++)
        {
            lengths[i] = new Length(lengthValues[i]);
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
