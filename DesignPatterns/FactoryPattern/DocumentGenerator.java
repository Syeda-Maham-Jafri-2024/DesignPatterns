// You are developing a document generation system for a word processing application. The system needs to support the creation of 
// various types of documents, such as letters, reports, and memos. Each document type may have specific formatting requirements, and 
// new document types may be added in the future without modifying existing code.

// Requirements:

// There should be a central document factory responsible for creating instances of different document types.
// The document factory should provide methods to create documents of various types, such as letters, reports, and memos.
// Each document type may have specific properties, such as headers, footers, and formatting styles.
// The system must be flexible enough to accommodate new document types without altering existing code.
// Documents should be created based on user preferences and selected options.
// Challenges:

// The document generation system must be easily extensible to support new document types.
// It should be possible to create documents with different configurations, such as varying headers, footers, and styles.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary class or classes for the chosen design pattern to ensure flexible document creation.
// Provide code snippets demonstrating how different parts of the application can create instances of documents using the factory method pattern.
import java.util.Scanner;
public class DocumentGenerator{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the document type you want: ");
        String str= sc.nextLine(); 
        Client client = new Client(str);
        documents doc = client.getDocument();
        System.out.println(doc.getdocumenttype());
        System.out.println(doc.getFormattingRequirements());

    }
}
interface documents{
    public String getdocumenttype();
    public String getFormattingRequirements();
}
class letter implements documents{
    public String getdocumenttype(){
        return "Letter";
    }
    public String getFormattingRequirements(){
        return "Formatting Requirements for Letter: Date, Address, Salutation, Body, Closing";
    }
}
class report implements documents{
    public String getdocumenttype(){
        return "Report";
    }
    public String getFormattingRequirements(){
        return "Formatting Requirements for Report:Title page, Table of contents, Executive Summary, Introduction, Body, Closing, Appendix";
    }
}
class memo implements documents{
    public String getdocumenttype(){
        return "Memo";
    }
    public String getFormattingRequirements(){
        return "Formatting Requirements for Memo: Heading, Salutation, Opening Statement, Call to action, Discussion, Closing";
    }
}
class DocumentFactory{
    public static documents CreateDocument(String doctype){
        if("Letter".equals(doctype)){
            return new letter();
        }
        else if("Report".equals(doctype)){
            return new report();
        }
        else if("Memo".equals(doctype)){
            return new memo();
        }
        else{
            System.out.println("Error: The document type you gave does not exists.");
        }
        return null;
    }
}
class Client{
    documents clientdoc;
    public Client(String doctype){
        this.clientdoc = DocumentFactory.CreateDocument(doctype);
    }

    public documents getDocument(){
     return clientdoc;
    }

}
