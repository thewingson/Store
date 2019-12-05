package kz.almat.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SeucrityInit extends AbstractSecurityWebApplicationInitializer {
}
