package org.example.apr;

public class Programmers_표현가능한이진트리 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            if(checkBinaryTree(numbers[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }


    private boolean checkBinaryTree(long number) {
        String target = Long.toBinaryString(number);
        target = generateFullBinary(target);
        int rootPos = target.length() / 2;

        if(target.charAt(rootPos) == '0') {
            return false;
        }

        String left = target.substring(0, rootPos);
        String right = target.substring(rootPos+1);

        return isBinaryTree(left) && isBinaryTree(right);

    }

    private boolean isBinaryTree(String target) {

        if(target.length() == 0) {
            return true;
        }

        int rootPos = target.length() / 2;

        if(target.charAt(rootPos) == '0') {
            return !target.contains("1");
        }
        String left = target.substring(0, rootPos);
        String right = target.substring(rootPos+1);

        return isBinaryTree(left) && isBinaryTree(right);

    }

    private String generateFullBinary(String target) {

        int current = target.length();
        int level = 1;
        int count = 1;

        while(current > count) {
            level <<= 1;
            count += level;
        }

        int result = count - current;
        return "0".repeat(result) + target;
    }
}
