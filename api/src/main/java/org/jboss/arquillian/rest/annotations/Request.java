package org.jboss.arquillian.rest.annotations;

import javax.ws.rs.core.MediaType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines the accepted media type for the response (ie the @javax.ws.rs.Produces media type of the server side service)
 *
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface Request {
    String[] value();
}
