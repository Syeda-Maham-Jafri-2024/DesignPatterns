// You are tasked with developing a framework for digital image processing that allows users to apply various filters and 
// transformations to images. Filters include basic ones like blur and sharpen, and transformations involve resizing, rotating, and 
// applying artistic effects. Users should be able to stack multiple filters and transformations on an image, and new filters or 
// transformations should be easily added without modifying existing code.
public class DigitalImageProcessing{
    public static void main(String[] args){
        image myimage = new rotate( new blur(new BlackWhiteImage()));
        System.out.println("Processing Details: " + myimage.getDescription());
        image myimagee = new resize( new sharpen(new ColorImage()));
        System.out.println("Processing Details: " + myimagee.getDescription());

    }
}

abstract class image{
    public abstract String getDescription();
}

class ColorImage extends image{
    public String getDescription(){
        return "Color Image";
    }
}
class BlackWhiteImage extends image{
    public String getDescription(){
        return "Black and White Image";
    }
}

abstract class FilterDecoration extends image{
    image yourimage;
    public FilterDecoration(image myimage){
        yourimage = myimage;
    }
    public abstract String getDescription( );
}

class blur extends FilterDecoration{
    public blur(image yourimage){
        super(yourimage);
        System.out.println("Adding filter: blur effect to your image.");
    }
    public String getDescription(){
      return yourimage.getDescription() + ", blur ";
    }
}
class sharpen extends FilterDecoration{
    public sharpen(image yourimage){
        super(yourimage);
        System.out.println("Adding filter: sharpening effect to your image.");
    }
    public String getDescription(){
      return yourimage.getDescription() + ", sharpen ";
    }
}

abstract class TransformationDecoration extends image{
    image yourimage;
    public TransformationDecoration(image myimage){
        yourimage = myimage;
    }
    public abstract String getDescription( );
}

class resize extends TransformationDecoration{
    public resize(image yourimage){
        super(yourimage);
        System.out.println("Adding Transformation: resizing your image.");
    }
    public String getDescription(){
      return yourimage.getDescription() + ", resized ";
    }
}
class rotate extends TransformationDecoration{
    public rotate(image yourimage){
        super(yourimage);
        System.out.println("Adding Transformation: rotating your image.");
    }
    public String getDescription(){
      return yourimage.getDescription() + ", rotated ";
    }
}