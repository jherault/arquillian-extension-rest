package org.jboss.arquillian.rest.annotations;

/**
 * Defines a cookie to be added to the request (ie: builder.cookie( new NewCookie(...)))
 *
 * @author <a href="mailto:jeremy.herault@gmail.com">Jeremy Herault</a>
 */
public @interface Cookie {
    static String NULL = "ORG.JBOSS.ARQUILLIAN.REST.COOKIE.NULL-STRING";
    String name();
    String value();
    String path() default NULL;
    String domain() default NULL;
    int version() default 1;
}
