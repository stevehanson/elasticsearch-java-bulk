package example;

import java.io.IOException;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Indexer {

	private Client client;
	private TweetService tweetService;
	
	@Autowired 
	public Indexer(@Qualifier("cluster") Client client, TweetService tweetService) {
		this.client = client;
		this.tweetService = tweetService;
	}
	
	public void indexSomeStuff() throws IOException {
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		
		for (Tweet tweet : tweetService.getTweets()) {
			bulkRequest.add(client.prepareIndex("twitter","tweet", String.valueOf(tweet.getId()) )
					.setSource(tweet.toJson()));
		}

		BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if (bulkResponse.hasFailures()) {
		    System.out.println("FAILURES!");
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		 ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		 Indexer indexer = context.getBean(Indexer.class);
		 indexer.indexSomeStuff();
	}
	
	
}
