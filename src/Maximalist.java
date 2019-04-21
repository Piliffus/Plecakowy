public class Maximalist extends Strategy
{
    @Override
    public void solveProblem(Plan plan, PriceList priceList)
    {
        priceList.sortRodsByLengthReverseOrder();
        plan.sortLengths();
    }
}
