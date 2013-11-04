package example;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public class BukIndexer {

	public Client setUpClient() {
		
		Node node = NodeBuilder.nodeBuilder().node();
		return node.client();
	}
}
