package org.jboss.arquillian.rest.annotations.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Registers a provider class.
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Register {
    Class provider();
}
