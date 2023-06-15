package stellarburgers.pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AppConfig {
    protected static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";

    protected RequestSpecification getSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .build();
    }
}
