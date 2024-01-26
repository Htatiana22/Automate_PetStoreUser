package io.pepstore.swagger.tasks;

import io.pepstore.swagger.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;
public class DeleteUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String endPointApi = Data.extractURL().get(0).get("EndPoint");
        String userName = Data.extractPost().get(0).get("userName");

        actor.attemptsTo(
                Delete.from(endPointApi+"/"+userName)
                        .with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );

    }
    public static DeleteUserTask delete (){
        return instrumented(DeleteUserTask.class);
    }

}
