import java.util.ArrayList;

public class Output
{
    public static void printRod(Rod rod)
    {
        System.out.println(rod.toString());
    }

    public static void printLength(Length length)
    {
        System.out.println(length.toString());
    }

    public static void printPrice(int totalPrice)
    {
        System.out.println(totalPrice);
    }

    public static void printWastage(int totalWastage)
    {
        System.out.println(totalWastage);
    }

    public static void printUsedRods(ArrayList<ArrayList<Length>> usedRods)
    {
        for (ArrayList<Length> rod: usedRods)
        {
            for (Length pieces : rod)
            {
                System.out.print(pieces.getValue() + " ");
            }
            System.out.print("\n");
        }
    }
}
