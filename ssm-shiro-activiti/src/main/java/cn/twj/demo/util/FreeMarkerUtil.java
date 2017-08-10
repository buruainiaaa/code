package cn.twj.demo.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
	private static FreeMarkerUtil instance;
    private Configuration config;
    
    /**
     * instance FreeMarkerUtil
     * @return
     */
    public static FreeMarkerUtil instance() {
        if (instance == null) {
            instance = new FreeMarkerUtil();
        }
        return instance;
    }
    
    /**
     * instance Configuration
     * @param request
     */
    private void configInstance(HttpServletRequest request,String templatePath) {
        if (this.config == null) {
            this.config = new Configuration();
            this.config.setServletContextForTemplateLoading(request.getSession().getServletContext(),templatePath);
        }
    }
    
    /**
     * 通过模板文件生成字符串
     * @param request
     * @param templateFileName
     * @param propMap
     * @return
     */
    public String geneFileStr(HttpServletRequest request,String templateFileName, Map<String, Object> propMap,String templatePath) {
        configInstance(request,templatePath);
        StringWriter out = new StringWriter();
        Template tmp;
        try {
            tmp = this.config.getTemplate(templateFileName,"UTF-8");
            tmp.setEncoding("UTF-8");
            tmp.process(propMap, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return out.getBuffer().toString();
    }
}
