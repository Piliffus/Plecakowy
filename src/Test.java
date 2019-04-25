public class Test
{
    public static void priceListTest(PriceList tested)
    {
        for (Rod rod : tested.getRods())
        {
            Output.printRod(rod);
        }
    }

    public static void planTest(Plan tested)
    {
        for (Length length : tested.getLengths())
        {
            Output.printLength(length);
        }
    }
}
