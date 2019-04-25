import java.util.ArrayList;
import java.util.Comparator;

public class Ecologic extends ComplexStrategy implements Comparator<ComplexStrategy>
{
    @Override
    public int compare(ComplexStrategy arg1, ComplexStrategy arg2)
    {
        return arg1.totalWastage - arg2.totalWastage;
    }

    @Override
    protected void sortSolutions(ArrayList<ComplexStrategy> solutions)
    {
        solutions.sort(this);
    }

    @Override
    protected ComplexStrategy makeNewSplit()
    {
        return new Ecologic(this.totalPrice, this.totalWastage, this.usedRods, this.howManyRods);
    }

    public Ecologic(int totalPrice, int totalWastage, ArrayList<ArrayList<Length>> usedRods, int howManyRods)
    {
        super(totalPrice, totalWastage, usedRods, howManyRods);
    }

    public Ecologic()
    {
        super();
    }
}
