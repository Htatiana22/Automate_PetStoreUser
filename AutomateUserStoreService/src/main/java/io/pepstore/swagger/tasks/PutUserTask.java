package io.pepstore.swagger.tasks;

import io.pepstore.swagger.models.UserModel;
import io.pepstore.swagger.questions.BuilDataUserPut;
import io.pepstore.swagger.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;
public class PutUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        UserModel dataUser = actor.asksFor(BuilDataUserPut.was());
        String endPointApi = Data.extractURL().get(0).get("EndPoint");
        String userName = Data.extractPut().get(0).get("userName");

        actor.attemptsTo(
                Put.to(endPointApi+"/"+userName)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .body(dataUser)
                        )
        );
    }
    public static PutUserTask put (){
        return instrumented(PutUserTask.class);
    }
}
