package example;


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

}
