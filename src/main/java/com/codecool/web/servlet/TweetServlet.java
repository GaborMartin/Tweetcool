package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
    private List<Tweet> tweets = new ArrayList<>();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String poster = request.getParameter("poster");
        String post = request.getParameter("post");

        Tweet user = new Tweet(poster, post);
        tweets.add(user);

        System.out.println("Added new tweet!");
        System.out.println("Poster: " + poster);
        System.out.println("Post: " + post);

        for (Tweet tweet : tweets) {
            System.out.println(tweet);
        }

        PrintWriter writer = response.getWriter();

        String htmlResponse = "<html> <head>\n" +
            "    <link rel=\"stylesheet\" href=\"tweet.css\">\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "  </head>";
        htmlResponse += "<h2>Poster: " + poster;
        htmlResponse += "<br>Post: " + post + "</br>";
        htmlResponse += "</html>";

        writer.println(htmlResponse);
    }
}
