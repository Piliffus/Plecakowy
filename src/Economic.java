import java.util.ArrayList;
import java.util.Comparator;

public class Economic extends ComplexStrategy implements Comparator<ComplexStrategy>
{
    @Override
    public int compare(ComplexStrategy arg1, ComplexStrategy arg2)
    {
        return arg1.totalPrice - arg2.totalPrice;
    }

    @Override
    protected void sortSolutions(ArrayList<ComplexStrategy> solutions)
    {
        solutions.sort(this);
    }

    public Economic(int totalPrice, int totalWastage, ArrayList<ArrayList<Length>> usedRods, int howManyRods)
    {
        super(totalPrice, totalWastage, usedRods, howManyRods);
    }

    public Economic()
    {
        super();
    }
}
