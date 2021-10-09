package org.howe.examples.rest.api;

import org.howe.examples.rest.Book;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Path("book")
public class BookResource {

    static Map<String, Book> library = new HashMap<>();

    public BookResource() {
    }

    @GET
    @Path("{isbn}")
    @Produces("application/json")
    public JsonObject getJson(@PathParam("isbn") String isbn) {
        return Json.createObjectBuilder().add(isbn, library.get(isbn).getTitle()).build();
    }

    /**
     * PUT method for updating or creating an instance of BookResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
        JsonReader jsonReader = Json.createReader(new StringReader(content));
        JsonObject object = jsonReader.readObject();
        library.put(object.getString("isbn"), new Book("genre", "anonymity", "TestBook"));
    }
}
