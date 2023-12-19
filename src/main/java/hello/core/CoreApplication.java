package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 스프링 부트는 자동 빈 과 수동 빈 overriding 을 기본적으로 허용하지 않는다.
 * bean-definition-overriding=true 설정해줘야지 사용가능하나, 지양해야하는 방법이다.
 */
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
