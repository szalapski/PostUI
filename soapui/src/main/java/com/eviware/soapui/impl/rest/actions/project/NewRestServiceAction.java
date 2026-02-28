

package com.eviware.soapui.impl.rest.actions.project;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.impl.actions.RestServiceBuilder;
import com.eviware.soapui.impl.actions.RestUriDialogHandler;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.MessageSupport;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.eviware.x.form.XFormDialog;

import static com.eviware.soapui.analytics.SoapUIActions.ADD_REST_SERVICE_FROM_URI;

/**
 * Actions for importing an existing SoapUI project file into the current
 * workspace
 *
 * @author Ole.Matzura
 */

public class NewRestServiceAction extends AbstractSoapUIAction<WsdlProject> {
    public static final String SOAPUI_ACTION_ID = "NewRestServiceAction";

    public static final MessageSupport messages = MessageSupport.getMessages(NewRestServiceAction.class);


    public NewRestServiceAction() {
        super(messages.get("Title"), messages.get("Description"));
    }

    public void perform(WsdlProject project, Object param) {
        RestUriDialogHandler dialogBuilder = new RestUriDialogHandler();
        RestServiceBuilder serviceBuilder = new RestServiceBuilder();
        XFormDialog dialog = dialogBuilder.buildDialog(messages);
        while (dialog.show()) {
            try {
                String uri = dialogBuilder.getUri();
                if (uri != null) {
                    serviceBuilder.createRestService(project, uri);
                }
                // If there is no exception or error we break out
                Analytics.trackAction(ADD_REST_SERVICE_FROM_URI);
                break;

            } catch (Exception ex) {
                UISupport.showErrorMessage(ex.getMessage());
                dialogBuilder.resetUriField();
            }
        }
    }
}
