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
	public JestClient jestClient() {
		 ClientConfig clientConfig = new ClientConfig.Builder("http://localhost:9200").multiThreaded(true).build();
		 JestClientFactory factory = new JestClientFactory();
		 factory.setClientConfig(clientConfig);
		 
		 return factory.getObject();
	}

}
