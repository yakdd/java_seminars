public class bitOperation {
    public static void main(String[] args) {
        // Инкременты и декременты:
        int a = 123;
        int b = 123;
        a = a-- - --a; // 2: 123 (123-1=122) - (122-1=121) 121 => 123 - 121 = 2
        System.out.println(a);
        b = --b - --b; // 1: (123-1=122) - (122-1=121) => 122 - 121 = 1
        System.out.println(b);
        System.out.println("------------------");

        // Побитовый сдвиг:
        int c = 8;
        c = c << 1;
        /*
         * побитовый сдвиг влево:
         * 8: bin = 1000
         * c << 1: 10000
         * 10000: dec = 16 => c = 16
         */
        System.out.println(c);
        int d = 18;
        d = d >> 1;
        System.out.println(d);
        /*
         * побитовый сдвиг вправо:
         * 18: bin = 10010
         * d >> 1: 1001
         * 1001: dec = 9 => d = 9
         */
        System.out.println("------------------");

        // Побитовые операции и или ...
        int x = 5;
        int y = 3;
        System.out.println(x | y); // побитовое "или" = 7
        System.out.println(x & y); // побитовое "и" = 1
        System.out.println(x ^ y); // побитовое "разделительное или" = 6
        /*
         * 
         */

    }
}
