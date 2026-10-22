public class Brackets
{
    public static void main(String[] args)
    {
        System.out.println("Should be true");
        System.out.println(checkBrackets(" "));
        System.out.println(checkBrackets("{}"));
        System.out.println(checkBrackets("{}{}"));
        System.out.println(checkBrackets("{{}}"));
        System.out.println(checkBrackets("{{{}{{}}}}"));

        System.out.println("\nShould be false");
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("}{"));
        System.out.println(checkBrackets("{}}{"));
        System.out.println(checkBrackets("{{}"));
        System.out.println(checkBrackets("{{}}}{}"));
    }
    
    public static boolean checkBrackets(String b)
    {
        int leftBrackets = 0;
        int rightBrackets = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '{') {
                leftBrackets++;
            } else if (b.charAt(i) == '}') {
                rightBrackets++;
                if (leftBrackets < rightBrackets) {
                    return false;
                }
            }
        }

        return leftBrackets == rightBrackets;
    }
}
