

package com.eviware.soapui.support;

import org.junit.Test;

/**
 * @author joel.jonsson
 */
public class JsonUtilTest {
    @Test
    public void canParseWithSurroundingWhitespace() {
        new JsonUtil().parseTrimmedText("    \n\n   {1:2}\n\n \t   ");
    }

    @Test
    public void canParseWithPrecedingWhile1() {
        new JsonUtil().parseTrimmedText(" \n  while(1);  \n\n   {1:2}\n\n \t   ");
    }
}
