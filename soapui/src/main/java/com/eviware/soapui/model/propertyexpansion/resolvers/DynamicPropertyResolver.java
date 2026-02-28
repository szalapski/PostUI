

package com.eviware.soapui.model.propertyexpansion.resolvers;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;
import com.eviware.soapui.model.propertyexpansion.resolvers.providers.CurrentStepIndexProvider;
import com.eviware.soapui.model.propertyexpansion.resolvers.providers.CurrentStepRunIndexProvider;
import com.eviware.soapui.model.propertyexpansion.resolvers.providers.ProjectDirProvider;
import com.eviware.soapui.model.propertyexpansion.resolvers.providers.WorkspaceDirProvider;
import com.eviware.soapui.plugins.SoapUIFactory;
import com.eviware.soapui.support.factory.SoapUIFactoryRegistryListener;

import java.util.HashMap;
import java.util.Map;

public class DynamicPropertyResolver implements PropertyResolver, SoapUIFactoryRegistryListener {
    private static Map<String, ValueProvider> providers = new HashMap<>();

    static {
        addProvider("projectDir", new ProjectDirProvider());
        addProvider("workspaceDir", new WorkspaceDirProvider());
        addProvider( "currentStepIndex", new CurrentStepIndexProvider() );
        addProvider( "currentStepRunIndex", new CurrentStepRunIndexProvider() );
    }

    public DynamicPropertyResolver() {
        for (ValueProviderFactory obj : SoapUI.getFactoryRegistry().getFactories(ValueProviderFactory.class)) {
            addProvider( obj );
        }

        SoapUI.getFactoryRegistry().addFactoryRegistryListener(this);
    }

    public String resolveProperty(PropertyExpansionContext context, String name, boolean globalOverride) {
        ValueProvider provider = providers.get(name);
        if (provider != null) {
            return provider.getValue(context);
        }

        return null;
    }

    public static void addProvider(String propertyName, ValueProvider provider) {
        providers.put(propertyName, provider);
    }

    public static void addProvider( ValueProviderFactory factory )
    {
        addProvider(factory.getValueId(), factory.createValueProvider());
    }

    public static void removeProvider( ValueProviderFactory factory )
    {
        providers.remove( factory.getValueId() );
    }

    @Override
    public void factoryAdded(Class<?> factoryType, Object factory) {
       if( factoryType.equals(ValueProviderFactory.class))
           addProvider((ValueProviderFactory)factory);
    }

    @Override
    public void factoryRemoved(Class<?> factoryType, Object factory) {
        if( factoryType.equals(ValueProviderFactory.class))
            removeProvider((ValueProviderFactory)factory);
    }

    public static interface ValueProvider {
        String getValue(PropertyExpansionContext context);
    }

    public static interface ValueProviderFactory extends SoapUIFactory {
        public ValueProvider createValueProvider();

        public String getValueId();
    }
}
