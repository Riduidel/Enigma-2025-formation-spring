package com.petclinic;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ListBeans {
	private static final Logger logger = LoggerFactory.getLogger(ListBeans.class);
	
	@Autowired ApplicationContext context;

	@Test
	void can_list_all_beans() {
        String[] beanNames = context.getBeanDefinitionNames();
        logger.trace(
        	Arrays.stream(beanNames)
        		.collect(Collectors.joining("\n\t", "All bean definitions\n\t", "\n"))
        		);

        Assertions.assertThat(context.getBeanDefinitionCount()).isGreaterThan(1);
	}

}
