package com.company;

public class ReversePolishNotation {

    public static int sum(String RPN) {
        String[] splitRPN = RPN.split(" ");
        Stos<Integer> valueStack = new Stos<Integer>();
        String a;
        int k = 0;
        while (k < splitRPN.length) {
            a = splitRPN[k];
            if (a.matches("[0-9]*"))
                valueStack.push(Integer.parseInt(a));
            else {
                int wynik = 0, aa = 0, bb = 0;
                aa = valueStack.deletePop();
                bb = valueStack.deletePop();
                switch (a) {
                    case "-":
                        wynik = bb - aa;
                        break;
                    case "+":
                        wynik = bb + aa;
                        break;
                    case "*":
                        wynik = bb * aa;
                        break;
                    case "/":
                        wynik = bb / aa;
                        break;
                }
                valueStack.push(wynik);
            }
            k++;
        }
        return valueStack.pop();
    }
    public static void main(String[] args) {
        String RPN = "100 11 + 10 * 20 /";
        System.out.println(sum(RPN));
    }
}
