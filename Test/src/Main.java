import java.util.Stack;

public class Main {

    public static void check(String word, String g1, String g2){

        char[] wordArray = word.toCharArray();
        char[] g1Array = g1.toCharArray();
        char[] g2Array = g2.toCharArray();

        Stack<Character> wordStack = new Stack<>();
        Stack<Character> g1Stack = new Stack<>();
        Stack<Character> g2Stack = new Stack<>();

        for (int i = wordArray.length - 1; i >= 0; i--){
            wordStack.push(wordArray[i]);
        }

        for (int i = g1Array.length - 1; i >= 0; i--){
            g1Stack.push(g1Array[i]);
        }

        for (int i = g2Array.length - 1; i >= 0; i--){
            g2Stack.push(g2Array[i]);
        }

        if (wordStack.peek().equals(g1Stack.peek())){
            wordStack.pop();
            g1Stack.pop();
            checkRecursive(wordStack, g1Stack, g2Stack);
        } else if (wordStack.peek().equals(g2Stack.peek())) {
            wordStack.pop();
            g2Stack.pop();
            checkRecursive(wordStack, g1Stack, g2Stack);
        }
    }

    public static boolean checkRecursive(Stack wordStack, Stack g1Stack, Stack g2Stack){

        if (wordStack.isEmpty()){
            System.out.println("Acabat");
            return true;
        }

        if (!g1Stack.isEmpty()) {
            if (wordStack.peek().equals(g1Stack.peek())) {
                wordStack.pop();
                g1Stack.pop();
                checkRecursive(wordStack, g1Stack, g2Stack);
            }
        }

        if (!g2Stack.isEmpty()){
            if (wordStack.peek().equals(g2Stack.peek())) {
                wordStack.pop();
                g2Stack.pop();
                checkRecursive(wordStack, g1Stack, g2Stack);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String word = "Making progress";
        String g1 = "Mak pross";
        String g2 = "inggre";

        check(word, g1, g2);

    }
}