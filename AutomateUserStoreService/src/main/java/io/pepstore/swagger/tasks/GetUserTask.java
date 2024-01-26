package io.pepstore.swagger.tasks;

import io.pepstore.swagger.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
public class GetUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String endPointApi = Data.extractURL().get(0).get("EndPoint");
        String userName = Data.extractPost().get(0).get("userName");

        actor.attemptsTo(
                Get.resource(endPointApi+"/"+userName).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );

    }
    public static GetUserTask get(){
        return instrumented(GetUserTask.class);
    }
}
