package org.jboss.arquillian.rest.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines a header of the request (catched by @javax.ws.rs.HeaderParam on the server side)
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface HeaderParam {

    String name();
    String value();
}
