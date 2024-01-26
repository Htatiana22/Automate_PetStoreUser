package io.pepstore.swagger.tasks;

import io.pepstore.swagger.models.UserModel;
import io.pepstore.swagger.questions.BuilDataPost;
import io.pepstore.swagger.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
public class PostUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        UserModel userData = actor.asksFor(BuilDataPost.was());
        String endPointApi = Data.extractURL().get(0).get("EndPoint");

        actor.attemptsTo(
               Post.to(endPointApi).with(
                       requestSpecification -> requestSpecification
                               .contentType(ContentType.JSON)
                               .body(userData)
                       )
       );

    }
    public static PostUserTask post(){
        return instrumented(PostUserTask.class);
    }
}


