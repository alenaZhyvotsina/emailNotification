package propets.email.dto;

import java.io.Serializable;
import java.util.List;

public class EmailListAndPostDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7049089389471168528L;
	
	List<String> emails;
	String postId;
	
	public EmailListAndPostDto() {
		
	}
	
	public EmailListAndPostDto(List<String> emails, String postId) {
		super();
		this.emails = emails;
		this.postId = postId;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "EmailListAndPostDto [emails=" + emails + ", postId=" + postId + "]";
	}
	
	
	
}
