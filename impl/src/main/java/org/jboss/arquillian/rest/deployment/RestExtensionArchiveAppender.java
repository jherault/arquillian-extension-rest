package org.jboss.arquillian.rest.deployment;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.shrinkwrap.api.Archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
public class RestExtensionArchiveAppender implements AuxiliaryArchiveAppender {
    @Override
    public Archive<?> createAuxiliaryArchive() {
        return null;
    }

    /*
     *  copied from the arquillian persistence extension
     *  @TODO list all needed libraries and add them to the archive
     *  @see  https://github.com/arquillian/arquillian-extension-persistence/blob/master/impl/src/main/java/org/jboss/arquillian/persistence/core/deployment/PersistenceExtensionArchiveAppender.java
     *
     */
    private String[] requiredLibraries()
    {
        List<String> libraries = new ArrayList<String>(Arrays.asList(
                "org.dbunit",
                "org.apache.commons",
                "org.apache.log4j",
                "org.slf4j",
                "org.yaml",
                "org.codehaus.jackson"
        ));

        return libraries.toArray(new String[libraries.size()]);
    }
}
