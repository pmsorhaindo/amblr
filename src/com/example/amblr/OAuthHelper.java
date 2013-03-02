package com.example.amblr;

import java.io.UnsupportedEncodingException;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

public class OAuthHelper {

	private OAuthConsumer mConsumer;
	private OAuthProvider mProvider;
	private String mCallbackUrl;

	
	public OAuthHelper(String consumerKey, String consumerSecret, String scope, String callbackUrl)

		throws UnsupportedEncodingException {
		    mConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
		    mProvider = new CommonsHttpOAuthProvider(
		    "http://www.tumblr.com/oauth/request_token",
		    //+ URLEncoder.encode(scope, "utf-8"),
		    "http://www.tumblr.com/oauth/access_token",
		    "https://www.tumblr.com/oauth/authorize?oauth_token=default");
		    mProvider.setOAuth10a(true);
		    mCallbackUrl = (callbackUrl == null ? OAuth.OUT_OF_BAND : callbackUrl);
		}
}