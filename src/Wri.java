public class Wri {
    public static void main(String[] args) {

        int n = 5;
        int m ;
        n |= n >>> 1;
        System.out.println(n);
        System.out.println(n>>>2);
        n |= n >>> 2;
        System.out.println(n);
        System.out.println(n>>>4);
        n |= n >>> 4;
        System.out.println(n);
        System.out.println(n>>>8);
        n |= n >>> 8;
        System.out.println(n>>>16);
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);

    }
}
