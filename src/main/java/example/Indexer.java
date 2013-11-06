package example;

import io.searchbox.client.JestClient;
import io.searchbox.core.Bulk;
import io.searchbox.core.Bulk.Builder;
import io.searchbox.core.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Indexer {

	private JestClient client;
	private TweetService tweetService;
	
	@Autowired 
	public Indexer(JestClient client, TweetService tweetService) {
		this.client = client;
		this.tweetService = tweetService;
	}
	
	public void indexSomeStuff() throws Exception {
		Builder bulkBuilder = new Bulk.Builder();
		
		for (Tweet tweet : tweetService.getTweets()) {
			System.out.println("Indexing tweet: " + tweet.getMessage());
			Index index = new Index.Builder(tweet).index("twitter").type("tweet").build();
			bulkBuilder.addAction(index);
		}
		
		client.execute(bulkBuilder.build());
		

	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		 ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		 Indexer indexer = context.getBean(Indexer.class);
		 indexer.indexSomeStuff();
	}
	
	
}
