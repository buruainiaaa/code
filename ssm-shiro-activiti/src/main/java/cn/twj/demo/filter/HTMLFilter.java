package cn.twj.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.servlet.ServletGroupTemplate;
import org.beetl.ext.web.SimpleCrossFilter;

public class HTMLFilter  extends SimpleCrossFilter implements Filter {

    public void init(FilterConfig arg0)throws ServletException {

    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
    ServletException
    {
              response.setContentType("text/html;charset=utf-8");
              super.doFilter(request,response, chain);
    }

    @Override
    protected GroupTemplate getGroupTemplate() {
              return ServletGroupTemplate.instance().getGroupTemplate();
    }
	



}
