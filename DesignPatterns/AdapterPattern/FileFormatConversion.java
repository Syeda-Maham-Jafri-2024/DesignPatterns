public class FileFormatConversion{
    public static void main(String[] args){
        doc document = new doc();

        fileformat adapter =  new  DOCtoPDFadapter(document);
        System.out.println(adapter.formatname());
        adapter.PDFconvert();
        

    }
}
interface fileformat{
    public String formatname();
    public void PDFconvert();
    public void PNGconvert();
    public void DOCconvert();
    public void JPEGconvert();
}
class pdf implements fileformat{
    public String formatname(){
        return "PDF ";
    }
    public void PDFconvert(){
        System.out.println("Converting to pdf");
    }
    public void DOCconvert(){
        System.out.println("Converting the pdf to doc");
    }
    public void PNGconvert(){
        System.out.println("Converting the pdf to png");
    }
    public void JPEGconvert(){
        System.out.println("Converting the pdf to jpeg");
    }

}
class doc implements fileformat{
    public String formatname(){
        return "DOC ";
    }
    public void DOCconvert(){
        System.out.println("Converting to doc");
    }
    public void PDFconvert(){
        System.out.println("Converting the doc to pdf");
    }
    public void PNGconvert(){
        System.out.println("Converting the doc to png");
    }
    public void JPEGconvert(){
        System.out.println("Converting the doc to jpeg");
    }
}
class png implements fileformat{
    public String formatname(){
        return "PNG ";
    }
    public void PNGconvert(){
        System.out.println("Converting to png");
    }
    public void DOCconvert(){
        System.out.println("Converting the png to doc");
    }
    public void PDFconvert(){
        System.out.println("Converting the png to pdf");
    }
    public void JPEGconvert(){
        System.out.println("Converting the png to jpeg");
    }

}
class jpeg implements fileformat{
 public String formatname(){
        return "JPEG ";
    }
    public void JPEGconvert(){
        System.out.println("Converting to jpeg");
    }
    public void DOCconvert(){
        System.out.println("Converting the jpeg to doc");
    }
    public void PNGconvert(){
        System.out.println("Converting the jpeg to png");
    }
    public void PDFconvert(){
        System.out.println("Converting the jpeg to pdf");
    }
}
class DOCtoPDFadapter implements fileformat{
    doc document;
    public DOCtoPDFadapter(doc newdoc){
        this.document = newdoc;
    }
    public String formatname(){
        return "PDF";
    }
    public void PDFconvert(){
        document.PDFconvert();
    }
    public void DOCconvert(){};
    public void JPEGconvert(){};
    public void PNGconvert(){};
}
// class DOCtoPNGadapter implements fileformat{
//     doc document;
//     public DOCtoPNGadapter(doc newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.PNGconvert();
//     }
// }
// class DOCtoJPEGadapter implements fileformat{
//     doc document;
//     public DOCtoJPEGadapter(doc newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.JPEGconvert();
//     }
// }
// class PDFtoDOCadapter implements fileformat{
//     pdf document;
//     public PDFtoDOCadapter(pdf newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.DOCconvert();
//     }
// }
// class PDFtoPNGadapter implements fileformat{
//     pdf document;
//     public PDFtoPNGadapter(pdf newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.PNGconvert();
//     }
// }
// class PDFtoJPEGadapter implements fileformat{
//     pdf document;
//     public PDFtoJPEGadapter(pdf newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.JPEGconvert();
//     }
// }
// class JPEGtoPDFadapter implements fileformat{
//     jpeg document;
//     public JPEGtoPDFadapter(jpeg newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.PDFconvert();
//     }
// }
// class JPEGtoPNGadapter implements fileformat{
//     jpeg document;
//     public JPEGtoPNGadapter(jpeg newdoc){
//         this.document = newdoc;
//     }
//     public void convert(){
//         document.PNGconvert();
//     }
// }
// class JPEGtoDocadapter implements fileformat{
//     jpeg document;
//     public JPEGtoDocadapter(jpeg newdoc){
//         this.document = newdoc;
//     }
//     public void DOCconvert(){
//         document.DOCconvert();
//     }
// }