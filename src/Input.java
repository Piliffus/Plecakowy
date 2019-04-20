import java.util.Scanner;

public class Input
{
    public static int getNumber()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] getNumber(int howMany)
    {
        Scanner scanner = new Scanner(System.in);
        int[] returning = new int[howMany];

        for (int i = 0; i < howMany; i++)
        {
            returning[i] = scanner.nextInt();
        }

        return returning;
    }

    public static String getString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}