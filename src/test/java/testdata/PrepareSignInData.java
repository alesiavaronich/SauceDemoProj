package testdata;

import constants.Credentials;
import models.SignInWithLombokBuilderModel;

public class PrepareSignInData {

    public SignInWithLombokBuilderModel getStandardUser() {
        return SignInWithLombokBuilderModel
                .builder()
                .username(Credentials.SAUCEDEMO_LOGIN_STANDARD_USER)
                .password(Credentials.SAUCEDEMO_PASSWORD)
                .build();
    }

    public SignInWithLombokBuilderModel getLockedOutUser() {
        return SignInWithLombokBuilderModel
                .builder()
                .username(Credentials.SAUCEDEMO_LOGIN_LOCKED_OUT_USER)
                .password(Credentials.SAUCEDEMO_PASSWORD)
                .build();
    }

    public SignInWithLombokBuilderModel getProblemUser() {
        return SignInWithLombokBuilderModel
                .builder()
                .username(Credentials.SAUCEDEMO_LOGIN_PROBLEM_USER)
                .password(Credentials.SAUCEDEMO_PASSWORD)
                .build();
    }

    public SignInWithLombokBuilderModel getPerformanceGlitchUser() {
        return SignInWithLombokBuilderModel
                .builder()
                .username(Credentials.SAUCEDEMO_LOGIN_PERFORMANCE_GLITCH_USER)
                .password(Credentials.SAUCEDEMO_PASSWORD)
                .build();
    }
}
