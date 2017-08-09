/**
 * 
 */
package test;

import com.js.core.util.PDFReport;

/**
 * @author oa_wenzongyuan
 */

public class PdfTest {
    public static void main(String[] args) throws Exception {
        testString();
    }

    public static void testPdf() throws Exception {
        PDFReport.htmlToPdf("你好我好大家好！！", "E:\\", "abc.pdf");
        System.out.println("成功！");
    }

    public static void testString() throws Exception {
        String str = "[123]";
        String s = str.substring(0, str.indexOf("]") + 1);
        System.out.println(s);
    }

}
