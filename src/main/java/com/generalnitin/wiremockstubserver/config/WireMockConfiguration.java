package com.generalnitin.wiremockstubserver.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
public class WireMockConfiguration {
    @Value("${wiremock.path:wiremock}")
    private String mockPath;
    private String prefix = "BOOT-INF/classes/"; //Prefix is required while running in jar format, not required when running using gradle bootRun

    @Bean(destroyMethod="stop", initMethod="start")
    public WireMockServer myAppMock() {
        ClasspathFileSource fileSource = new ClasspathFileSource(mockPath);
        if (fileSource.getUri().getPath() == null) {
            mockPath =prefix + mockPath;
        }
        return new WireMockServer(options().port(8555).
                usingFilesUnderClasspath(mockPath).
                notifier(new ConsoleNotifier(true)));
    }

    /**
     * This bean is responsible for forwarding calls to wiremock
     * It matches any request that starts with /hello/mock
     * and forwards it to http://localhost:8555/hello/mock/ where wiremock will be running
     * @return
     */
    @Bean
    public ServletRegistrationBean proxyServletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ProxyServlet(),"/hello/mock/*");
        registrationBean.addInitParameter("targetUri", "http://localhost:8555/hello/mock/");
        return registrationBean;
    }

}
