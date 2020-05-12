package ru.geekbrains.algorithms.hw03.stacks;

public class Brackets {
    public static void main(String[] args) {
        String text = "public static void main(String] args) {" +
                "        Stack<Integer> stack = new ArrayStackImpl<>();" +
                "        fillStackByRandomIntegers(stack, 10);" +
                "        printStack(stack);" +
                "    }";

        new Brackets(text).check();
    }

    private final String text;

    Brackets(String text) {
        this.text = text;
    }

    public void check() {
        Stack<Character> stack = new StackArrayImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            checkCharacter(text.charAt(i), i, stack);
        }
    }

    private void checkCharacter(char character, int index, Stack<Character> stack) {
        switch (character) {
            case '(':
            case '[':
            case '{':
                stack.push(character);
                break;
            case ')':
            case ']':
            case '}':
                if (stack.isEmpty()) {
                    System.out.printf("Fault closing bracket %c in the %d position\n", character, index);
                    return;
                }
                char c = stack.pop();
                if (((character == ')') && (c != '('))
                        || ((character == ']') && (c != '['))
                        || ((character == '}') && (c != '{'))) {
                    System.out.printf("Fault closing bracket %c in the %d position\n", character, index);
                }
                break;
        }
    }
}
