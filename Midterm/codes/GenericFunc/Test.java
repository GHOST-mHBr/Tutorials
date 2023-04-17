public class Test {

    public static <T extends MyInt> String someGenericFunction(T a , T b){
        return a.talk() +" | "+ b.talk();
    }

    public static void main(String[] args) {
        System.out.println(someGenericFunction(new TestInt(), new TestInt2()));
    }
}