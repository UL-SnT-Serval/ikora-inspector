package org.ikora.inspector;

import org.ikora.inspector.run.Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.ikora.inspector.repository")
@EntityScan("org.ikora.inspector.model")
public class IkoraInspectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}
