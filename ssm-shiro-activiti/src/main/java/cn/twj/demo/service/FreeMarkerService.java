package cn.twj.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FreeMarkerService {
	@Value("${cody.freemarker.template-path}")
	private String template;
	
	
}
