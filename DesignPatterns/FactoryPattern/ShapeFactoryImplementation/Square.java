public class Square implements Shape{
    @Override
    public String Identity() {
        return "I am a Square";
    }

    @Override
    public String drawShape() {
        return "Drawing a Square";
    }

    @Override
    public String eraseShape() {
        return "Erasing the Square";
    }
}
