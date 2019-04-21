import java.util.Arrays;

public class Plan
{
    private Length[] lengths;
    private int size;

    public void sortLengths()
    {
        Arrays.sort(lengths, 0, size);
        reverseLengths();
    }

    private void reverseLengths()
    {
        for (int i = 0, j = size-1; i <= (size-1) / 2; i++, j--)
        {
            Length helper = lengths[i];
            lengths[i] = lengths[j];
            lengths[j] = helper;
        }
    }

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
