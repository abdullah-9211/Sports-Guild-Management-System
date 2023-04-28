package com.example.i200444_i200518_project;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBHelper {
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guild_schema", "root", "monsterofthegalaxy");
        return connection;
    }



    public void checker(){
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //=================================================LOGIN====================================================//

    public User login(User user) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where user_name = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
            if (resultSet.next()){
                User user1 = new User(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), resultSet.getString("user_type"));
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //=======================================ADDING USERS=========================================//

    public boolean addCaptain(Captain captain) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO `guild_schema`.`users` (`user_name`, `cnic`, `roll_number`, `password`, `user_type`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, captain.getUsername());
            preparedStmt.setString(2, captain.getCnic());
            preparedStmt.setString(3, captain.getRoll_num());
            preparedStmt.setString(4, captain.getPassword());
            preparedStmt.setString(5, "captain");
            preparedStmt.execute();

            String sql2 = "INSERT INTO `guild_schema`.`captains` (`user_name`, `cnic`, `roll_number`, `password`, `kit_num`, `sport`)" + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, captain.getUsername());
            preparedStmt2.setString(2, captain.getCnic());
            preparedStmt2.setString(3, captain.getRoll_num());
            preparedStmt2.setString(4, captain.getPassword());
            preparedStmt2.setInt(5, captain.getKit_num());
            preparedStmt2.setString(6, captain.getSport());
            preparedStmt2.execute();
            con.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addMember(Member member) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO `guild_schema`.`users` (`user_name`, `cnic`, `roll_number`, `password`, `user_type`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, member.getUsername());
            preparedStmt.setString(2, member.getCnic());
            preparedStmt.setString(3, member.getRoll_num());
            preparedStmt.setString(4, member.getPassword());
            preparedStmt.setString(5, "member");
            preparedStmt.execute();

            String sql2 = "INSERT INTO `guild_schema`.`teammates` (`user_name`, `cnic`, `roll_number`, `password`, `kit_number`, `sport`)" + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, member.getUsername());
            preparedStmt2.setString(2, member.getCnic());
            preparedStmt2.setString(3, member.getRoll_num());
            preparedStmt2.setString(4, member.getPassword());
            preparedStmt2.setInt(5, member.getKit_num());
            preparedStmt2.setString(6, member.getSport());
            preparedStmt2.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addExec(Executive executive) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO `guild_schema`.`users` (`user_name`, `cnic`, `roll_number`, `password`, `user_type`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, executive.getUsername());
            preparedStmt.setString(2, executive.getCnic());
            preparedStmt.setString(3, executive.getRoll_num());
            preparedStmt.setString(4, executive.getPassword());
            preparedStmt.setString(5, "ec");
            preparedStmt.execute();

            String sql2 = "INSERT INTO `guild_schema`.`executive` (`user_name`, `cnic`, `roll_number`, `password`, `post`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, executive.getUsername());
            preparedStmt2.setString(2, executive.getCnic());
            preparedStmt2.setString(3, executive.getRoll_num());
            preparedStmt2.setString(4, executive.getPassword());
            preparedStmt2.setString(5, executive.getPost());
            preparedStmt2.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addAdmin(Admin admin) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO `guild_schema`.`users` (`user_name`, `cnic`, `roll_number`, `password`, `user_type`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, admin.getUsername());
            preparedStmt.setString(2, admin.getCnic());
            preparedStmt.setString(3, admin.getRoll_num());
            preparedStmt.setString(4, admin.getPassword());
            preparedStmt.setString(5, "admin");
            preparedStmt.execute();

            String sql2 = "INSERT INTO `guild_schema`.`admin` (`user_name`, `cnic`, `roll_number`, `password`)" + "VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, admin.getUsername());
            preparedStmt2.setString(2, admin.getCnic());
            preparedStmt2.setString(3, admin.getRoll_num());
            preparedStmt2.setString(4, admin.getPassword());
            preparedStmt2.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    //=====================================GETTING SPECIFIC USER TYPE================================================//

    public Admin getAdmin(String user_name) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admin where user_name = '" + user_name + "'");
            if (resultSet.next()){
                Admin user1 = new Admin(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), "admin");
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Executive getEC(String username) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from executive where user_name = '" + username + "'");
            if (resultSet.next()){
                Executive user1 = new Executive(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), "ec", resultSet.getString("post"));
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public Captain getCap(String user_name) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from captains where user_name = '" + user_name + "'");
            if (resultSet.next()){
                Captain user1 = new Captain(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), "captain", resultSet.getInt("kit_num"), resultSet.getString("sport"));
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Member getMember(String user_name) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teammates where user_name = '" + user_name + "'");
            if (resultSet.next()){
                Member user1 = new Member(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), "member", resultSet.getInt("kit_number"), resultSet.getString("sport"));
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //=================================================ADD ANNOUNCEMENT==================================================//

    public boolean addAnnouncement(Announcement announcement) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO `guild_schema`.`announcements` (`title`, `content`, `date`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, announcement.getTitle());
            preparedStmt.setString(2, announcement.getDesc());
            preparedStmt.setString(3, announcement.getDate());
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //==========================================GET ALL ANNOUNCEMENTS============================================//

    public ArrayList<Announcement> getAnnouncements() {
        ArrayList<Announcement> announcements = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from announcements");
            while (resultSet.next()){
                Announcement announcement = new Announcement(resultSet.getString("date"), resultSet.getString("title"), resultSet.getString("content"));
                announcements.add(announcement);
            }
            return announcements;
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcements;
    }

    //=================================ADDING EVENT================================================//
    public boolean addEvent(Event event) {
        try {
            Connection con = getConnection();
            String sql2 = "INSERT INTO `guild_schema`.`events` (`eventname`, `date`, `venue`, `description`)" + "VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, event.getEventName());
            preparedStmt2.setString(2, event.getDate());
            preparedStmt2.setString(3, event.getVenue());
            preparedStmt2.setString(4, event.getDesc());
            preparedStmt2.execute();

            Date d = new Date();
            String sql = "INSERT INTO `guild_schema`.`announcements` (`title`, `content`, `date`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, event.getEventName() + " Event");
            preparedStmt.setString(2, event.getEventName() + ", Venue: " + event.getVenue() + ", on " + event.getDate());
            preparedStmt.setString(3, d.toString());
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //=======================================ADD MEETING=========================================//
    public boolean addMeeting(Meeting meeting) {
        try {
            Connection con = getConnection();
            String sql2 = "INSERT INTO `guild_schema`.`meeting` (`date`, `time`, `venue`, `calledby`, `agenda`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, meeting.getDate());
            preparedStmt2.setString(2, meeting.getTime());
            preparedStmt2.setString(3, meeting.getVenue());
            preparedStmt2.setString(4, meeting.getCalledBy());
            preparedStmt2.setString(5, meeting.getAgenda());
            preparedStmt2.execute();

            Date d = new Date();
            String sql = "INSERT INTO `guild_schema`.`announcements` (`title`, `content`, `date`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, "Meeting Scheduled!!!");
            preparedStmt.setString(2, "Meeting called by " + meeting.getCalledBy() + " called on " + meeting.getDate() + " at " + meeting.getTime() + ",  Venue: " + meeting.getVenue());
            preparedStmt.setString(3, d.toString());
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //=====================================ADDING/RETRIEVING ATTENDANCE================================================//

    public static Boolean addAttendance(Attendance attendance) {
        try {
            Connection con = getConnection();
            String date = attendance.getDate();
            String sport = attendance.getSport();
            ArrayList<String> roll_numbers = attendance.getPlayers();
            ArrayList<String> present = attendance.getAttendance();
            for (int i = 0; i < roll_numbers.size(); i++) {
                String sql = "INSERT INTO `guild_schema`.`attendance` (`date`, `roll_number`, `sport`, `present`)" + "VALUES (?, ?, ?, ?);";
                PreparedStatement preparedStmt = con.prepareStatement(sql);
                preparedStmt.setString(1, date);
                preparedStmt.setString(2, roll_numbers.get(i));
                preparedStmt.setString(3, sport);
                preparedStmt.setString(4, present.get(i));
                preparedStmt.execute();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String> getAttendanceDates(String roll) {
        try{
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select date from attendance where roll_number = '" + roll + "'");
            ArrayList<String> dates = new ArrayList<>();
            while (resultSet.next()){
                dates.add(resultSet.getString("date"));
            }
            return dates;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> getAttendance(String roll) {
        try{
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select present from attendance where roll_number = '" + roll + "'");
            ArrayList<String> attendance = new ArrayList<>();
            while (resultSet.next()){
                attendance.add(resultSet.getString("present"));
            }
            return attendance;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<String> getTeamAttendance(String sport){
        try{
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select present from attendance where sport = '" + sport + "'");
            ArrayList<String> attendance = new ArrayList<>();
            while (resultSet.next()){
                attendance.add(resultSet.getString("present"));
            }
            return attendance;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //=====================================RETRIEVING TEAMMEMBERS================================================//
    public static ArrayList<String> getTeamMembers(String sport) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teammates where sport = '" + sport + "'");
            ArrayList<String> team_members = new ArrayList<>();
            while (resultSet.next()){
                team_members.add(resultSet.getString("roll_number"));
            }
            return team_members;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> getTeamMemberNames(String sport) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teammates where sport = '" + sport + "'");
            ArrayList<String> team_members = new ArrayList<>();
            while (resultSet.next()){
                team_members.add(resultSet.getString("user_name"));
            }
            return team_members;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //==========================================ADD FIXTURE============================================//
    public boolean addFixture(Fixture fixture) {
        try {
            Connection con = getConnection();
            String sql2 = "INSERT INTO `guild_schema`.`fixture` (`venue`, `sport`, `date`, `hometeam`, `awayteam`)" + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, fixture.getVenue());
            preparedStmt2.setString(2, fixture.getSport());
            preparedStmt2.setString(3, fixture.getDate());
            preparedStmt2.setString(4, fixture.getHomeTeam());
            preparedStmt2.setString(5, fixture.getAwayTeam());
            preparedStmt2.execute();

            Date d = new Date();
            String sql = "INSERT INTO `guild_schema`.`announcements` (`title`, `content`, `date`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, "Upcoming " + fixture.getSport() + " Fixture!!");
            preparedStmt.setString(2, "Fixture of " + fixture.getHomeTeam() + " vs " + fixture.getAwayTeam() + " on " + fixture.getDate() + ".  Venue: " + fixture.getVenue());
            preparedStmt.setString(3, d.toString());
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //======================RETRIEVING FIXTURES===============================//

    public static ResultSet getFixtures(String sport){
        try{
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fixture where sport = '" + sport + "'");
            return resultSet;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //============================================ADD PRACTICE===================================================//

    public boolean addPractice(Practice practice) {
        try {
            Connection con = getConnection();
            String sql2 = "INSERT INTO `guild_schema`.`practice` (`date`, `time`, `sport`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, practice.getDay());
            preparedStmt2.setString(2, practice.getTime());
            preparedStmt2.setString(3, practice.getSport());
            preparedStmt2.execute();

            Date d = new Date();
            String sql = "INSERT INTO `guild_schema`.`announcements` (`title`, `content`, `date`)" + "VALUES (?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, practice.getSport() + " Practice Scheduled!!");
            preparedStmt.setString(2, practice.getSport() + " Practice scheduled on " + practice.getDay() + "s at " + practice.getTime());
            preparedStmt.setString(3, d.toString());
            preparedStmt.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //=================================GET ALL EQUIPMENT======================================//

    public boolean getEquipment(String name){
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from equipment where name = '" + name + "'");
            if (resultSet.next()){
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    private int getEquipmentQuantity(String name) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from equipment where name = '" + name + "'");
            if (resultSet.next()){
                return resultSet.getInt("quantity");
            }
            else {
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    //====================================ADDING EQUIPMENT============================================//

    public boolean addEquipment(EquipmentInventory equipmentInventory) {
        try {
            Connection con = getConnection();
            if (getEquipment(equipmentInventory.getName())){
                int quan = getEquipmentQuantity(equipmentInventory.getName());
                String sql = "UPDATE `guild_schema`.`equipment` SET `quantity` = ? WHERE `name` = ?;";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, (quan + equipmentInventory.getQuantity()));
                preparedStatement.setString(2, equipmentInventory.getName());
                preparedStatement.execute();
            }
            else {
                String sql2 = "INSERT INTO `guild_schema`.`equipment` (`name`, `quantity`)" + "VALUES (?, ?);";
                PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
                preparedStmt2.setString(1, equipmentInventory.getName());
                preparedStmt2.setInt(2, equipmentInventory.getQuantity());
                preparedStmt2.execute();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //=======================================REMOVE EQUIPMENT==============================================//

    public boolean removeEquipment(EquipmentInventory equipmentInventory) {
        try {
            Connection con = getConnection();
            if (getEquipment(equipmentInventory.getName())){
                int quan = getEquipmentQuantity(equipmentInventory.getName());
                quan -= equipmentInventory.getQuantity();
                if (quan < 0){
                    return false;
                }
                else if (quan == 0){
                    String sql = "DELETE FROM `guild_schema`.`equipment` WHERE `name` = ?;";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, equipmentInventory.getName());
                    preparedStatement.execute();
                    return true;
                }
                String sql = "UPDATE `guild_schema`.`equipment` SET `quantity` = ? WHERE `name` = ?;";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, quan);
                preparedStatement.setString(2, equipmentInventory.getName());
                preparedStatement.execute();

            }
            else {
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //============================================ADDING TEAM==============================================//
    public boolean addTeam(Team team) {
        try {
            Connection con = getConnection();
            String sql2 = "INSERT INTO `guild_schema`.`team` (`teamname`, `sport`)" + "VALUES (?, ?);";
            PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
            preparedStmt2.setString(1, team.getTeamName());
            preparedStmt2.setString(2, team.getSport());
            preparedStmt2.execute();

            for (String s : team.getPlayers()){
                String sql = "INSERT INTO `guild_schema`.`plays_for` (`teamname`, `sport`, `username`)" + "VALUES (?, ?, ?);";
                PreparedStatement preparedStmt = con.prepareStatement(sql);
                preparedStmt.setString(1, team.getTeamName());
                preparedStmt.setString(2, team.getSport());
                preparedStmt.setString(3, s);
                preparedStmt.execute();
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //=====================================EXTRACT ALL PRACTICES FOR THAT SPORT===================================//

    public static ArrayList<Practice> getPractices(String sport) {
        ArrayList<Practice> practices = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from practice where sport = '" + sport + "'");
            while (resultSet.next()){
                Practice p = new Practice(resultSet.getString("date"), resultSet.getString("time"), resultSet.getString("sport"));
                practices.add(p);
            }
            return practices;
        }catch (Exception e){
            e.printStackTrace();
        }
        return practices;
    }


    //====================================EXTRACT CAPTAIN OF TEAM===============================================//

    public static Captain getCaptain(String sport) {
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from captains where sport = '" + sport + "'");
            if (resultSet.next()){
                Captain user1 = new Captain(resultSet.getString("user_name"), resultSet.getString("cnic"), resultSet.getString("password"), resultSet.getString("roll_number"), "captain", resultSet.getInt("kit_num"), resultSet.getString("sport"));
                return user1;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
