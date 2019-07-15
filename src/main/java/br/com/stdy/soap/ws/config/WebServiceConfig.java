package br.com.stdy.soap.ws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet (ApplicationContext context) {

		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformSchemaLocations(true);

		return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
	}
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema cousesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://stdy-soap.com.br/courses");
		definition.setLocationUri("http://localhost:8080/ws");
		definition.setSchema(cousesSchema);
		
		return definition;
	}
	
	@Bean
	public XsdSchema cousesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));	
	}
}
