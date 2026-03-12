public class Calculate {
    public static int add(int a, int b){
        return a+b;

    }
    public static int minue(int a, int b){
        return a - b;
    }
    public static int multi(int a, int b){
        return a * b;
    }

    public static double devide(int a, int b){
        if(b == 0){
            throw new RuntimeException("Cannot devide by zero");
        }
        return (double) a / b;
    }
}


