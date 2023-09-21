package edu.idat.pe;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configurable
public class Configuracion {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> mensaje(ApplicationContext ac){
		MessageDispatcherServlet ob = new MessageDispatcherServlet();
		ob.setApplicationContext(ac);
		ob.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(ob, "/sw/*");
	}
	
	@Bean(name = "facultad")
	public DefaultWsdl11Definition definiresquema(XsdSchema esquema) {
		DefaultWsdl11Definition ob = new DefaultWsdl11Definition();
		ob.setPortTypeName("FacultadPort");
		ob.setLocationUri("/sw");
		ob.setTargetNamespace("http://facultadbances.com/sw");
		ob.setSchema(esquema);
		return ob;
	}
	
	@Bean
	public XsdSchema esquema() {
		return new SimpleXsdSchema(new ClassPathResource("Esquema.xsd"));
	}
	
}
