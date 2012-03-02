package ${context.packageName};

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.ContextParamWebApplicationFactory;
import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = {@WebInitParam(name = ContextParamWebApplicationFactory.APP_CLASS_PARAM, value = "${context.className}")})
public class ${context.className} extends WicketFilter {
}
