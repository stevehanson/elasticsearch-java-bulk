package example;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("test")
public class SpringConfig {

	
	@Bean @Qualifier("embedded")
	public Client embeddedClient() {
		Node node = NodeBuilder.nodeBuilder().node();
		return node.client();
	}
	
	@Bean @Qualifier("cluster")
	public Client clusterClient() {
		return new TransportClient().
				addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
	}
	
	@Bean BulkRequestBuilder bulkRequest() {
		return clusterClient().prepareBulk();
	}
}
