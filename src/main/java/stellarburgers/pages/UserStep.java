package stellarburgers.pages;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class UserStep extends AppConfig {
    private static final String CREATE_USER = "/api/auth/register";
    private static final String LOGIN_USER = "/api/auth/login";
    private static final String USER_USER = "/api/auth/user";
    @Step("Create User")
    public ValidatableResponse createUser(User user) {
        ValidatableResponse response = given()
                .spec(getSpecification())
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
        user.setToken(response.extract().path("accessToken"));
        return response;
    }
    @Step("Authorize User")
    public ValidatableResponse loginUser(User user) {
        ValidatableResponse response = given()
                .spec(getSpecification())
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
        user.setToken((response.extract().path("accessToken")));
        return response;
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(User user) {
        return given()
                .spec(getSpecification())
                .header("Authorization", user.getToken())
                .delete(USER_USER + "user")
                .then();
    }
}
