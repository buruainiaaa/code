package com.js.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

public class PDFReport {
    // 支持中文
    public static void htmlToPdf(String htmlString, String outputFile, String fileName) throws Exception {
        File file = new File(outputFile);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileN = new File(outputFile, fileName);
        if (!fileN.exists()) {
            fileN.createNewFile();
        }
        OutputStream os = new FileOutputStream(outputFile + "/" + fileName);
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        StringBuffer html = new StringBuffer();
        // DOCTYPE 必需写否则类似于 这样的字符解析会出现错误
        html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">").append("<head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />")
                .append("<style type=\"text/css\" mce_bogus=\"1\">body {font-family: SimSun;}</style>").append("</head>").append("<body>");
        html.append("<div>" + parseXhtml(htmlString) + "</div>");
        html.append("</body></html>");
        renderer.setDocumentFromString(html.toString());
        // 解决图片的相对路径问题
        // renderer.getSharedContext().setBaseURL("file:/F:/teste/html/");
        renderer.layout();
        renderer.createPDF(os);
        System.out.println("======转换成功!");
        os.close();
    }

    public static String parseXhtml(String f_in) throws IOException {

        ByteArrayInputStream stream = new ByteArrayInputStream(f_in.getBytes());

        ByteArrayOutputStream tidyOutStream = new ByteArrayOutputStream();
        // 实例化Tidy对象
        Tidy tidy = new Tidy();
        // 设置输入
        tidy.setInputEncoding("utf-8");
        // 如果是true 不输出注释，警告和错误信息
        tidy.setQuiet(true);
        // 设置输出
        tidy.setOutputEncoding("utf-8");
        // 不显示警告信息
        tidy.setShowWarnings(false);
        // 缩进适当的标签内容。
        tidy.setIndentContent(true);
        // 内容缩进
        tidy.setSmartIndent(true);
        tidy.setIndentAttributes(false);
        // 只输出body内部的内容
        tidy.setPrintBodyOnly(true);
        // 多长换行
        tidy.setWraplen(1024);
        // 输出为xhtml
        tidy.setXHTML(true);
        // 去掉没用的标签
        tidy.setMakeClean(true);
        // 清洗word2000的内容
        tidy.setWord2000(true);
        // 设置错误输出信息
        tidy.setErrout(new PrintWriter(System.out));
        tidy.parse(stream, tidyOutStream);
        return tidyOutStream.toString();
    }
}
