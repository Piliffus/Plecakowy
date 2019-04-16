public class Plan
{
    int[] lengths;

    public void setSize(int arg)
    {
        lengths = new int[arg];
    }

    public void setPiece(int i, int arg)
    {
            lengths[i] = arg;
    }
}
