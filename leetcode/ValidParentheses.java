import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.print(isValid("()[{}()()[]]{}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            } else if (c == '}') {
                if (stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

}
