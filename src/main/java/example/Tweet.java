package example;

import java.io.IOException;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

public class Tweet {

	private Integer id;
	private String user;
	private String message;
	
	public Tweet(Integer id, String user, String message) {
		this.id = id;
		this.user = user;
		this.message = message;
	}
	
	public Integer getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getMessage() {
		return message;
	}
	
	public XContentBuilder toJson() throws IOException {
		return XContentFactory.jsonBuilder()
        .startObject()
            .field("id", this.id)
            .field("user", this.user)
            .field("message", this.message)
        .endObject();
	}
}
