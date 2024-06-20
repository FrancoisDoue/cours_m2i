package demo.demo_rest_2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/hello-world")
public class HelloResource {

    @Context
    private UriInfo uriInfo;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;


    @GET
    @Produces("text/plain")
    public String hello() {
        HttpSession session = request.getSession();
//        System.out.println(uriInfo.getAbsolutePath());
        return "Hello, World!";
    }

    @GET
    @Path("/set-cookie")
    @Produces(MediaType.TEXT_PLAIN)
    public Response setCookie() {
        NewCookie cookie = new NewCookie("isLogged", "true");
        return Response.ok("Tiens, prends un cookie.").cookie(cookie).build();
    }

    @GET
    @Path("/get-cookie")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCookie() {
        List<Cookie> cookies = Arrays.stream(request.getCookies()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        cookies.forEach(c -> sb.append(c.getName()).append("=").append(c.getValue()).append(";\n"));
        if (sb.length() > 0) {
            return Response.ok(sb.toString()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Pas de cookies").build();
    }

    @GET
    @Path("/set-session")
    @Produces(MediaType.TEXT_PLAIN)
    public Response setSession() {
        HttpSession session = request.getSession(true);
        session.setAttribute("isLogged", true);
        return Response.ok("Ajouté à la session").build();
    }

    @GET
    @Path("/get-session")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSession() {
        HttpSession session = request.getSession(false);
        if (session == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        boolean isLogged = (boolean) session.getAttribute("isLogged");
        if (isLogged)
            return Response.ok("Session lue et connecté").build();
        return Response.ok("Session lue mais pas connecté").build();
    }

}