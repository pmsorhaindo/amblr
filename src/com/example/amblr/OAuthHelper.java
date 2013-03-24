package com.example.amblr;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class OAuthHelper extends Activity {

	private OAuthConsumer mConsumer;
	private OAuthProvider mProvider;
	private String mCallbackUrl;

	
	public OAuthHelper(String consumerKey, String consumerSecret, String callbackUrl)

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
	
	public void getRequestToken()
	throws OAuthMessageSignerException, OAuthNotAuthorizedException,
	OAuthExpectationFailedException, OAuthCommunicationException {
		System.out.println("just before exec: provider - " + mProvider.getAccessTokenEndpointUrl());
	    String authUrl = mProvider.retrieveRequestToken(mConsumer,
	    mCallbackUrl);
	    
	    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl));
	    startActivity(browserIntent);
	}

}