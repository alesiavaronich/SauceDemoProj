package models;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SignInWithLombokBuilderModel {

    private String username;
    private String password;
}
