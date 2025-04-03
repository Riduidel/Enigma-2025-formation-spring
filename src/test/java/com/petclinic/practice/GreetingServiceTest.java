package com.petclinic.practice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class GreetingServiceTest {
	@Autowired
    private GreetingService greetingService;
	
	@Autowired ApplicationContext applicationContext;

    @Test
    public void can_say_hi() {
        // Given
        var tested = greetingService;
        // When
        var text = tested.sayHi();
        // Then
        assertThat(text).isEqualTo("Hello John");
    }

    @Test public void has_multiple_beans() {
        String[] beanNames = this.applicationContext.getBeanDefinitionNames();
        System.out.println("All beans in the application context:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        assertThat(applicationContext.getBeanDefinitionCount()).isGreaterThan(1);
    }
}