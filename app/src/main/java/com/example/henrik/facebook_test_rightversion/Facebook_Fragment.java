package com.example.henrik.facebook_test_rightversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.widget.LikeView;

public class Facebook_Fragment extends Fragment {

    private CallbackManager mCallbackManager;
    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {

        @Override
        public void onSuccess(LoginResult loginResult) {
            Profile profile = Profile.getCurrentProfile();
            messageDisplay(profile);
        }

        @Override
        public void onCancel() {
        //För framtida bruk.
        }

        @Override
        public void onError(FacebookException error) {
        //För framtida bruk.
        }
    };

    public Facebook_Fragment(){
        //För framtida bruk.
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager=CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        LoginButton logInButton = (LoginButton) view.findViewById((R.id.login_Button));

        logInButton.setReadPermissions("user_friends");
        logInButton.setFragment(this);
        logInButton.registerCallback(mCallbackManager, mCallback);

        //Kod för likebutton
        LikeView likeView = (LikeView) getView().findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.STANDARD);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);
        likeView.setObjectIdAndType("https://www.facebook.com/tekkeninformationcentre/",
                LikeView.ObjectType.OPEN_GRAPH);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
    super.onResume();
        Profile profile = Profile.getCurrentProfile();
        messageDisplay(profile);
    }

    private void messageDisplay(Profile profile){
        if(profile != null){
            setTextInTextView("Välkommen " + profile.getName());
        }
    }

    private void setTextInTextView(String message){
        TextView text_details = (TextView)getView().findViewById(R.id.text_details);
        text_details.setText(message);
    }


}
