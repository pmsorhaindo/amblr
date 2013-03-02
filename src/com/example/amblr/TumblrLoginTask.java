package com.example.amblr;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TumblrApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.os.AsyncTask;

public class TumblrLoginTask
{
	private static final String PROTECTED_RESOURCE_URL = "http://api.tumblr.com/v2/blog/atouchoverrated.tumblr.com/followers";
	
	Scanner in;
	Token requestToken;
	private OAuthService service;
	
	public TumblrLoginTask(){
		
		System.out.println("Instantiation yo!");
		
		service = new ServiceBuilder()
		.provider(TumblrApi.class)
		.apiKey("WaUMb2iLXPv4jFIV3z58aAYbhUXnxXO2rOw5gPOURIrmMkbup3")
		.apiSecret("Rlc0dQLFhx8MWyNxRVaPiB8gEBEXQVInyXDjCBe0VPq5QZhOlQ")
		.build();
		
		in = new Scanner(System.in);	
	}
	
	public Boolean login() {
		
		System.out.println("=== Tumblr's OAuth Workflow ===");
		System.out.println();
		
		// Obtain the Request Token
		System.out.println("Fetching the Request Token...");
		//requestToken = service.getRequestToken();
		System.out.println("Got the Request Token!");
		System.out.println();
		
		System.out.println("Now go and authorize Amblr here:");
		System.out.println(service.getAuthorizationUrl(requestToken));
		
		return null;
	}
	
	protected void theRest(String verif) {
		
		Verifier verifier = new Verifier(verif);
		System.out.println();
		
		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		Token accessToken = service.getAccessToken(requestToken, verifier);
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: " + accessToken + " )");
		System.out.println();
		
		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());
		
		System.out.println();
		
	}
}