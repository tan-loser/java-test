public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String str = "http://sicna.com.cn";
        int b = str.indexOf(':');
        int e = str.indexOf('.',b+1);
        System.out.println(str.substring(b+3,e));
        System.out.println(str.indexOf(".",13));
    }
}

