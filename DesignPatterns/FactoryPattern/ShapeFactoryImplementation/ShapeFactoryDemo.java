public class ShapeFactoryDemo {
    public static void main(String[] args){
         
        ShapeFactory shapefac = new ShapeFactory();
        Shape shape1= shapefac.getShape("CIRCLE");
        System.out.println(shape1.Identity());
        System.out.println(shape1.drawShape());
        System.out.println(shape1.eraseShape());
    }
}
