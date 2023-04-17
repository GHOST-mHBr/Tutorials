public class BoxTest {

    public static void main(String[] args){
        Box<String> sBox = new Box<>();
        Box<Integer> iBox = new Box<>();
        Box<Sample> sampleBox = new Box<>();
        
        Sample s = new Sample();

        sBox.put("Some text");
        iBox.put(12);
        sampleBox.put(s);


        System.out.println(sBox.get());
        System.out.println(iBox.get());

    }
    
}
