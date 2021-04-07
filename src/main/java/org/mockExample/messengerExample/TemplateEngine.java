package org.mockExample.messengerExample;

public interface TemplateEngine {
    String prepareMessage(Template template, Client client);
}
