public class Bits {
    public static void main(String args[]) {
        for (int i = 0; i < 32; i++) {
            int[] bits = { 0, 0, 0, 0, 0 };
            for (int j = 0; j < 5; j++) {
                bits[4-j] = (i >> j) % 2;
            }
            System.out.println("Bits of " + i + ": " + bits[0] + bits[1] + bits[2] + bits[3] + bits[4]);
        }
        System.out.println("Congrats!\nwe have bits");
    }
}