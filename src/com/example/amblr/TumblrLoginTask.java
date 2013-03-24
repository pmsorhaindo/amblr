package com.example.amblr;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class TumblrLoginTask extends Activity
{
	private static final String PROTECTED_RESOURCE_URL = "http://api.tumblr.com/v2/blog/atouchoverrated.tumblr.com/followers";
	
	Scanner in;
	//Token requestToken;
	//private OAuthService service;
	String strConsumerKey = "WaUMb2iLXPv4jFIV3z58aAYbhUXnxXO2rOw5gPOURIrmMkbup3";
	String strConsumerSecret = "Rlc0dQLFhx8MWyNxRVaPiB8gEBEXQVInyXDjCBe0VPq5QZhOlQ";
	//String strScope = "";
	String strCallbackUrl = "ablr-auth://WWW.pmsorhaindo.com/amblr";
	OAuthHelper helper = null;
	
	
	
	public TumblrLoginTask(){
		
		try {
			System.out.println("Trying to make a helper");
			helper = new OAuthHelper(strConsumerKey,strConsumerSecret,strCallbackUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println("Instantiation yo!");
		
		service = new ServiceBuilder()
		.provider(TumblrApi.class)
		.apiKey("WaUMb2iLXPv4jFIV3z58aAYbhUXnxXO2rOw5gPOURIrmMkbup3")
		.apiSecret("Rlc0dQLFhx8MWyNxRVaPiB8gEBEXQVInyXDjCBe0VPq5QZhOlQ")
		.build();
		
		in = new Scanner(System.in);*/
		
	}
	
	
	
	public Boolean login() {
		
		try {
		    //String uri = helper.getRequestToken();
		    //System.out.println("yo the uri is: "+uri);
		    //startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com")));
		    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
		    startActivity(browserIntent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		/*System.out.println("=== Tumblr's OAuth Workflow ===");
		System.out.println();
		
		// Obtain the Request Token
		System.out.println("Fetching the Request Token...");
		requestToken = service.getRequestToken();
		System.out.println("Got the Request Token!");
		System.out.println();
		
		System.out.println("Now go and authorize Amblr here:");
		System.out.println(service.getAuthorizationUrl(requestToken));
		*/
		return true;
	}
	
	protected void theRest(String verif) {
		
		/*Verifier verifier = new Verifier(verif);
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
		
		System.out.println();*/
		
	}
}