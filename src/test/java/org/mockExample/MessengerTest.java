package org.mockExample;

import org.junit.Test;
import org.mockExample.messengerExample.*;

import javax.swing.event.CaretListener;

import static org.mockito.Mockito.*;
import static org.junit.Test.*;

public class MessengerTest {
    //create dummy object
    Template template = mock(Template.class);
    Client client = mock(Client.class);

    //mock object
    MailServer mailServer = mock(MailServer.class);
    TemplateEngine templateEngine = mock(TemplateEngine.class);

    final String CLIENT_EMAIL = "yosua.ardi@ti.ukdw.ac.id";
    final String CLIENT_MSG = "Hello World!";
    @Test
    public void shouldSendEmail(){
        //stub test
        //prepare SUT
        Messenger sut = new Messenger(mailServer, templateEngine);
        when(client.getEmail())
                .thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client))
                .thenReturn(CLIENT_MSG);
        //ACT
        sut.sendMessage(client, template);

        //Verify
        //spy test
        verify(mailServer).send(CLIENT_EMAIL, CLIENT_MSG);
    }
}
