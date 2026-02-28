

package com.eviware.soapui.impl.wadl.inference.support;

import com.eviware.soapui.impl.wadl.inference.ConflictHandler;
import com.eviware.soapui.impl.wadl.inference.InferredSchema;
import com.eviware.soapui.impl.wadl.inference.schema.SchemaSystem;
import com.eviware.soapui.inferredSchema.SchemaSetConfig;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class InferredSchemaImpl implements InferredSchema {
    private SchemaSystem ss;

    public InferredSchemaImpl() {
        ss = new SchemaSystem();
    }

    public InferredSchemaImpl(InputStream is) throws XmlException, IOException {
        ss = new SchemaSystem(SchemaSetConfig.Factory.parse(is));
    }

    public String[] getNamespaces() {
        return ss.getNamespaces().toArray(new String[0]);
    }

    public SchemaTypeSystem getSchemaTypeSystem() {
        return getSchemaTypeSystem(XmlBeans.getBuiltinTypeSystem());
    }

    public SchemaTypeSystem getSchemaTypeSystem(SchemaTypeSystem sts) {
        List<XmlObject> schemas = new ArrayList<>();
        try {
            for (String namespace : getNamespaces()) {
                // schemas.add( XmlObject.Factory.parse( getXsdForNamespace(
                // namespace ).toString() ) );
                schemas.add(XmlUtils.createXmlObject(getXsdForNamespace(namespace).toString()));
            }
            return XmlBeans.compileXsd(sts, schemas.toArray(new XmlObject[0]), XmlBeans.getBuiltinTypeSystem(), null);
        } catch (XmlException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getXsdForNamespace(String namespace) {
        return ss.getSchemaForNamespace(namespace).toString();
    }

    public void learningValidate(XmlObject xml, ConflictHandler handler) throws XmlException {
        ss.validate(xml, handler);
    }

    public void processValidXml(XmlObject xml) throws XmlException {
        ss.validate(xml, new AllowAll());
    }

    public void save(OutputStream os) throws IOException {
        SchemaSetConfig xml = SchemaSetConfig.Factory.newInstance();
        ss.save(xml);
        xml.save(os);
    }

    public boolean validate(XmlObject xml) {
        try {
            ss.validate(xml, new DenyAll());
            return true;
        } catch (XmlException e) {
            return false;
        }
    }

    public void deleteNamespace(String ns) {
        ss.deleteNamespace(ns);
    }

}
