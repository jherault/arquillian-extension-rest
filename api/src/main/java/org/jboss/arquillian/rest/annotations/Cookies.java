package org.jboss.arquillian.rest.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Defines a set of cookies to be added to the request.
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface Cookies {
    Cookie[] value();
}
