

package com.eviware.soapui.impl.wsdl.loadtest.strategy;

import com.eviware.soapui.support.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry of LoadFactorys
 *
 * @author Ole.Matzura
 */

public class LoadStrategyRegistry {
    private static LoadStrategyRegistry instance;
    private Map<String, LoadStrategyFactory> factories = new HashMap<>();

    public LoadStrategyRegistry() {
        addFactory(new SimpleLoadStrategy.Factory());
        addFactory(new BurstLoadStrategy.Factory());
        addFactory(new VarianceLoadStrategy.Factory());
        addFactory(new ThreadCountChangeLoadStrategy.Factory());
    }

    public void addFactory(LoadStrategyFactory factory) {
        factories.put(factory.getType(), factory);
    }

    public String[] getStrategies() {
        return StringUtils.sortNames(factories.keySet().toArray(new String[factories.size()]));
    }

    public static LoadStrategyRegistry getInstance() {
        if (instance == null) {
            instance = new LoadStrategyRegistry();
        }

        return instance;
    }

    public LoadStrategyFactory getFactory(String type) {
        return factories.get(type);
    }
}
