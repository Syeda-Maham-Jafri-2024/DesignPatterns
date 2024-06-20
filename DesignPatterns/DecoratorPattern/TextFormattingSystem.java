// You are building a text formatting system where users can apply various formatting options to a 
//document. The system needs to support basic text formatting such as bold, italic, and underline, as 
//well as allow for additional formatting options to be added in the future.

// Requirements:
// Implement a decorator pattern to enhance the text formatting capabilities.
// Text should be the base component, and formatting options (bold, italic, underline) should be decorators.
// Users should be able to apply multiple formatting options to a single piece of text.
// It should be possible to introduce new formatting options without modifying existing code.

// Challenges:
// Ensure that the decorator pattern enables the combination of multiple formatting options.
// Design the system to support easy addition of new formatting options.

// Tasks:
// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary classes for the chosen design pattern to enable flexible text formatting.
// Provide code snippets demonstrating how users can apply various formatting options to text using the decorator pattern.

public class TextFormattingSystem{
    public static void main(String[] args){
      text document = new Bold(new Italic(new Underline(new PlainText())));
      System.out.println("Formatting Applied: " + document.getDescription());
    }

}

interface text{ 
   public String getDescription();
}

class PlainText implements text{
    public String getDescription(){
        return "Plain Text ";
    }

}

abstract class FormattingDecorator implements text{
  protected text basictext;

  public FormattingDecorator(text yourtext){
      basictext = yourtext;
  }
  
  public String getDescription(){
      return basictext.getDescription();
  }
  
   
}

class Bold extends FormattingDecorator{
    
    public Bold(text yourtext){
        super(yourtext);
        System.out.println("Making your text Bold.");
    }
    
    public String getDescription(){
    return basictext.getDescription() + ", bold ";
    }
    
}

class Italic extends FormattingDecorator{
    
    public Italic(text yourtext){
        super(yourtext);
        System.out.println("Making your text Italic.");
    }
    
    public String getDescription(){
    return basictext.getDescription() + ", italic ";
    }
    
}

class Underline extends FormattingDecorator{
    
    public Underline(text yourtext){
        super(yourtext);
        System.out.println("Underlining your text.");
    }
    
    public String getDescription(){
    return basictext.getDescription() + ", underline ";
    }
    
}
