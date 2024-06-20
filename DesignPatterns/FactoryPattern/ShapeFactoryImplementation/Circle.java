public class Circle implements Shape {

    @Override
    public String Identity() {
       return "I am a Circle";
    }

    @Override
    public String drawShape() {
        return "Drawing the Circle";
    }

    @Override
    public String eraseShape() {
        return "Erasing the Circle";
    }
    
}
