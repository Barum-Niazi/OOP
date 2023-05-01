import java.util.ArrayList;
import java.util.Scanner;

class Generic<T> {

    ArrayList<T> stack = new ArrayList<T>();

    public void pushStack(T data) {
        stack.add(data);
    }

    public void popStack() {
        T data = stack.get(stack.size() - 1);
        System.out.println(data);
        stack.remove(stack.size() - 1);
    }

}

public class GenericTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        Generic g = new Generic();
        do {
            System.out.println("1 to push, 2 to pop");
            i = input.nextInt();
            if (i == 1) {
                g.pushStack(5.5);
                g.pushStack("Test");
                g.pushStack(1);
            }
            if (i == 2) {
                g.popStack();
            }
        } while (i != 0);

    }
}