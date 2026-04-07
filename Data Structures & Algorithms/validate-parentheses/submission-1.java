class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
               stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
               if (!stack.isEmpty() && operatorMatches(stack.pop(), c))
                 continue;
               else
                 return false;
            }
        }
        if (stack.isEmpty()) 
            return true;
        return false;
    }

    boolean operatorMatches(Character operatorFromStack, Character operator) {
        switch (operator) {
            case ')':
              return operatorFromStack == '(';
            case '}':
              return operatorFromStack == '{';
            case ']':
              return operatorFromStack == '[';
            default:
              return false;
        }
    }
}
