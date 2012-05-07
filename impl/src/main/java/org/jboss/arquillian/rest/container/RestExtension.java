package org.jboss.arquillian.rest.container;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.rest.deployment.RestExtensionArchiveAppender;

/**
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
public class RestExtension implements LoadableExtension {
    @Override
    public void register(ExtensionBuilder builder) {

        builder.service(AuxiliaryArchiveAppender.class, RestExtensionArchiveAppender.class);

    }

}
