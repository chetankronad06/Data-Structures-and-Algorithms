class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && a < 0 && top >= 0 && stack[top] > 0) {
                int b = stack[top];
                if (b < -a) {
                    top--;
                } else if (b == -a) {
                    top--;
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) stack[++top] = a;
        }

        int[] res = new int[top + 1];
        for (int i = 0; i <= top; i++) res[i] = stack[i];
        return res;
    }
}
