package org.jboss.arquillian.rest.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Defines a set of URL parameters to add to the REST path.
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface QueryParams {

    QueryParam[] value();
}
