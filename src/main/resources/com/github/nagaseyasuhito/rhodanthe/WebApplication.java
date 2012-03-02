package ${context.packageName};

import org.apache.wicket.Page;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import com.github.nagaseyasuhito.wicket.TransactionalRequestCycleListener;
import ${context.packageName}.page.IndexPage;
import com.google.inject.persist.jpa.JpaPersistModule;

public class ${context.className} extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }

    @Override
    protected void init() {
        super.init();

        this.getComponentInstantiationListeners().add(new GuiceComponentInjector(this, new JpaPersistModule("default")));
        this.getRequestCycleListeners().add(new TransactionalRequestCycleListener());
    }
}
