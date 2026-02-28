
package com.eviware.soapui.monitor;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.mock.MockRunContext;
import com.eviware.soapui.model.mock.MockRunner;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.settings.HttpSettings;
import com.eviware.soapui.settings.SSLSettings;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JettyMockEngineTest {

    @Mock
    private MockRunner mockRunner;
    @Mock
    private MockRunContext mockRunContext;
    @Mock
    private MockService mockService;

    // system under test (sut)
    private JettyMockEngine sut;
    private Field addedSslConnectorField;

    @Before
    public void setUp() throws Exception {
        SoapUI.getSettings().setString(SSLSettings.MOCK_PASSWORD, "abc");
        SoapUI.getSettings().setString(SSLSettings.MOCK_KEYSTORE_PASSWORD, "abc");
        SoapUI.getSettings().setBoolean(HttpSettings.LEAVE_MOCKENGINE, false);
        SoapUI.getSettings().setBoolean(SSLSettings.ENABLE_MOCK_SSL, true);
        SoapUI.getSettings().setLong(SSLSettings.MOCK_PORT, 8443);

        sut = new JettyMockEngine();
        when(mockRunner.getMockContext()).thenReturn(mockRunContext);
        when(mockRunContext.getMockService()).thenReturn(mockService);
        when(mockService.getPort()).thenReturn(30000);

        addedSslConnectorField = JettyMockEngine.class.getDeclaredField("addedSslConnector");
        addedSslConnectorField.setAccessible(true);
        assertFalse("The sslConnector must not be added before starting the mockService.", (Boolean) addedSslConnectorField.get(sut));
    }

    @Test
    public void restartMockService() throws Exception {
        // Given the mock service with SSL has been started & stopped
        sut.startMockService(mockRunner);
        assertTrue("The sslConnector must be added after starting the mockService!", (Boolean) addedSslConnectorField.get(sut));
        sut.stopMockService(mockRunner);
        assertFalse("The sslConnector must not be added after stopping the mockService!", (Boolean) addedSslConnectorField.get(sut));

        // When
        sut.startMockService(mockRunner);

        // Then
        assertTrue("The sslConnector must be added after restarting the mockService!", (Boolean) addedSslConnectorField.get(sut));
    }
}