package example;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TweetService {

	public List<Tweet> getTweets() {
		return Arrays.asList(new Tweet[] {
			new Tweet(1, "Steve", "I love elasticSearch!"),
			new Tweet(2, "Justin", "Solr is better!"),
			new Tweet(3, "Cody", "I love pop-tarts!")
		});
	}
}
