public class Rectangle implements Shape{

    @Override
    public String Identity() {
        return "I am a Rectangle";
    }

    @Override
    public String drawShape() {
        return "Drawing a Rectangle";
    }

    @Override
    public String eraseShape() {
        return "Erasing the Rectangle";
    }
    
}
