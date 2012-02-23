package ${context.decolatedPackageName};

import javax.servlet.annotation.WebFilter;

import com.google.inject.servlet.GuiceFilter;

@WebFilter("/*")
public class ${context.decolatedClassName} extends GuiceFilter {
}
