package io.github.w3code.api;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {
    @Step("Get authorization cookie")
    public static String getAuthorizationCookie(String user, String password) {

        return given()
                .contentType("application/x-www-form-urlencoded")
                .queryParam("controller", "authentication")
                .body("email=" + user + "&passwd=" + password + "&back=my-account&SubmitLogin=")
                .when()
                .post("/index.php")
                .then()
                .extract().response().getCookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364");
    }
}
