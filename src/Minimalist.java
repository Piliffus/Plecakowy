public class Minimalist extends Strategy
{
    @Override
    public void solveProblem(Plan plan, PriceList priceList)
    {
            priceList.sortRodsByLength();
            plan.sortLengths();
    }
}
