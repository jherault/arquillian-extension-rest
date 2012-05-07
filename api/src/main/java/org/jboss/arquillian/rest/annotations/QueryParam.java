package org.jboss.arquillian.rest.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines an URL parameter to add to the REST path (catched by @javax.ws.rs.QueryParam on the server side)
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface QueryParam {

    String name();
    String value();
}
