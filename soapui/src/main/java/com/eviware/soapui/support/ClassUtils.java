

package com.eviware.soapui.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {
    public static List<Class<?>> getImplementedAndExtendedClasses(Object obj) {
        ArrayList<Class<?>> result = new ArrayList<>();
        addImplementedInterfacesFromSuperClass(obj.getClass(), result);
        return result;
    }

    public static List<Class<?>> getSuperInterfaces(Class clazz) {
        ArrayList<Class<?>> result = new ArrayList<>();
        addImplementedSuperInterfaces(clazz, result);
        return result;
    }
    
    private static void addImplementedSuperInterfaces(Class clazz, ArrayList<Class<?>> result) {
		addImplementedInterfaces(clazz, result);
		
		Class<?> superclass = clazz.getSuperclass();
		
		if (superclass != null) {
			addImplementedSuperInterfaces(superclass, result);
		}		
	}

	private static void addImplementedInterfacesFromSuperClass(Class<?> clazz, ArrayList<Class<?>> result) {
        result.add(clazz);
        // result.addAll( Arrays.asList( clazz.getInterfaces() ));
        addImplementedInterfaces(clazz, result);
        if (clazz.getSuperclass() != null) {
            addImplementedInterfacesFromSuperClass(clazz.getSuperclass(), result);
        }
    }

    private static void addImplementedInterfaces(Class<?> intrfc, ArrayList<Class<?>> result) {
        // result.add( intrfc.getClass() );
        Class<?>[] interfacesArray = intrfc.getInterfaces();
        if (interfacesArray.length > 0) {
            result.addAll(Arrays.asList(interfacesArray));
            for (int i = 0; i < interfacesArray.length; i++) {
                Class<?> class1 = interfacesArray[i];
                addImplementedInterfaces(class1, result);
            }
        }
    }

}
