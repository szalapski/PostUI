

package com.eviware.soapui.impl.rest.support;

import com.eviware.soapui.impl.rest.support.handlers.DefaultMediaTypeHandler;
import com.eviware.soapui.impl.rest.support.handlers.HtmlMediaTypeHandler;
import com.eviware.soapui.impl.rest.support.handlers.JsonMediaTypeHandler;

import java.util.ArrayList;
import java.util.List;

public class MediaTypeHandlerRegistry {
    private static List<MediaTypeHandler> mediaTypeHandlers = new ArrayList<>();
    private static MediaTypeHandler defaultMediaTypeHandler = new DefaultMediaTypeHandler();

    static {
        mediaTypeHandlers.add(new JsonMediaTypeHandler());
        mediaTypeHandlers.add(new HtmlMediaTypeHandler());
    }

    public static MediaTypeHandler getTypeHandler(String contentType) {
        for (MediaTypeHandler handler : mediaTypeHandlers) {
            if (handler.canHandle(contentType)) {
                return handler;
            }
        }

        return defaultMediaTypeHandler;
    }

    public static MediaTypeHandler getDefaultMediaTypeHandler() {
        return defaultMediaTypeHandler;
    }

    public static void setDefaultMediaTypeHandler(MediaTypeHandler defaultMediaTypeHandler) {
        MediaTypeHandlerRegistry.defaultMediaTypeHandler = defaultMediaTypeHandler;
    }
}
