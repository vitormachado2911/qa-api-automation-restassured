package tests;

import base.BaseTest;
import io.restassured.common.mapper.TypeRef;
import models.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostsTest extends BaseTest {

    @Test
    void deveRetornar200EListaCom100PostsAoBuscarPosts() {
        List<Post> posts =
                given()
                        .when()
                        .get("/posts")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<List<Post>>() {
                        });

        assertThat(posts, hasSize(100));

        Post first = posts.get(0);
        assertThat(first.getUserId(), notNullValue());
        assertThat(first.getId(), notNullValue());
        assertThat(first.getTitle(), not(isEmptyOrNullString()));
        assertThat(first.getBody(), not(isEmptyOrNullString()));
    }

    @Test
    void deveRetornarPostComId1QuandoBuscarPorId() {
        Post post =
                given()
                        .pathParam("id", 1)
                        .when()
                        .get("/posts/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Post.class);

        assertThat(post.getId(), is(1));
    }

    @Test
    void deveValidarContratoJsonDoPostAoBuscarPorId() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }
}

