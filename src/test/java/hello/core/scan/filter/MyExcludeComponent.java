package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * 제외할 빈 객체 명시
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
