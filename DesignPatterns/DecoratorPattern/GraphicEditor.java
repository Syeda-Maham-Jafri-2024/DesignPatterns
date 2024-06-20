// You are developing a graphic editor application that allows users to create and manipulate various 
// shapes. The system needs to support not only basic shapes (e.g., circles, rectangles) but also 
//provide advanced functionalities such as adding borders, shadows, and textures to the shapes.

// Requirements:
// Implement a decorator pattern to enhance the graphic editor's shape customization capabilities.
// Shapes should be the base components, and decorators should represent advanced functionalities.
// Users should be able to apply multiple decorators to a single shape.
// It should be possible to introduce new advanced functionalities without modifying existing code.

// Challenges:
// Ensure that the decorator pattern enables the dynamic combination of multiple advanced functionalities.
// Design the system to handle the rendering and manipulation of shapes with various decorators.

// Tasks:
// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary classes for the chosen design pattern to enable flexible customization of shapes in the graphic editor.
// Provide code snippets demonstrating how users can apply various advanced functionalities to shapes using the decorator pattern.

public class GraphicEditor{
    public static void main(String[] args){
        shapes Shape1 = new Shadows(new Border(new Texture(new Circle())));
        System.put.println("Formatting: " + Shape1.getDescription());
        System.out.println();
        shapes Shape2 = new Shadows(new Border(new Texture(new Rectangle())));
        System.put.println("Formatting: " + Shape2.getDescription());
        System.out.println();
        shapes Shape3 = new Shadows(new Border(new Texture(new Square())));
        System.put.println("Formatting: " + Shape3.getDescription());

    }
}

interface shapes{ 
   public String getDescription();
}

class Rectangle implements shapes{
    public String getDescription(){
        return "Rectangle";
    }

}
class Square implements shapes{
    public String getDescription(){
        return "Square";
    }

}class Circle implements shapes{
    public String getDescription(){
        return "Circle";
    }

}
abstract class FormattingDecorator implements shapes{
  protected shapes Shape;

  public FormattingDecorator(shapes myshape){
      Shape = myshape;
  }
  
  public String getDescription(){
      return Shape.getDescription();
  }
  
   
}

class Border extends FormattingDecorator{
    
    public Border(shapes yourshape){
        super(yourshape);
        System.out.println("Adding borders to your shape.");
    }
    
    public String getDescription(){
    return Shape.getDescription() + ", borders ";
    }
    
}

class Shadows extends FormattingDecorator{
    
     public Shadows(shapes yourshape){
        super(yourshape);
        System.out.println("Adding Shadows to your shape.");
    }
    
    public String getDescription(){
    return Shape.getDescription() + ", shadows ";
    }
   
}

class Texture extends FormattingDecorator{
    
     public Texture(shapes yourshape){
        super(yourshape);
        System.out.println("Adding texture to your shape.");
    }
    
    public String getDescription(){
    return Shape.getDescription() + ", texture ";
    }
    
}
