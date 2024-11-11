<%@ page import="com.fitnesstracker.Activity" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Activities</title>
</head>
<body>
    <h1>Activities</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Activity Name</th>
            <th>Duration (min)</th>
            <th>Calories Burned</th>
            <th>Date</th>
        </tr>
        <%
            // Retrieve the activities list from the request attribute
            ArrayList<Activity> activities = (ArrayList<Activity>) request.getAttribute("activities");

            // Check if the activities list is not null
            if (activities != null && !activities.isEmpty()) {
                for (Activity activity : activities) {
        %>
        <tr>
            <td><%= activity.getId() %></td>
            <td><%= activity.getActivityName() %></td>
            <td><%= activity.getDuration() %></td>
            <td><%= activity.getCaloriesBurned() %></td>
            <td><%= activity.getDate() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <!-- Display a message if no activities were found -->
        <tr>
            <td colspan="5">No activities found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>