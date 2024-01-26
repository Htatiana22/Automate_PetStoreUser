package io.pepstore.swagger.questions;

import io.pepstore.swagger.models.UserModel;
import io.pepstore.swagger.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;
public class BuilDataPost implements Question <UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        Map <String, String> data = Data.extractPost().get(0);

        UserModel userModel = UserModel.builder()
                .id(Long.parseLong(data.get("id")))
                .username(data.get("userName"))
                .firstName(data.get("firstName"))
                .lastName(data.get("lastName"))
                .email(data.get("email"))
                .password(data.get("password"))
                .phone(data.get("phone"))
                .userStatus(Long.parseLong(data.get("userStatus")))
                .build();

        return userModel;
    }
    public static BuilDataPost was(){
        return new BuilDataPost();
    }
}
