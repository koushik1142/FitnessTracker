package com.fitnesstracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addActivity")
public class AddActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String activityName = request.getParameter("activityName");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int caloriesBurned = Integer.parseInt(request.getParameter("caloriesBurned"));
        String date = request.getParameter("date");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO activities (activity_name, duration, calories_burned, date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, activityName);
            stmt.setInt(2, duration);
            stmt.setInt(3, caloriesBurned);
            stmt.setString(4, date);
            stmt.executeUpdate();
            response.sendRedirect("viewActivities");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding activity");
        }
    }
}