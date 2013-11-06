package example;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example")
public class SpringConfig {

	
	@Bean
	public JestClient embeddedClient() {
		 ClientConfig clientConfig = new ClientConfig.Builder("http://localhost:9200").multiThreaded(true).build();
		// Construct a new Jest client according to configuration via factory
		 JestClientFactory factory = new JestClientFactory();
		 factory.setClientConfig(clientConfig);
		 return factory.getObject();
	}

}
