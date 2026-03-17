import java.sql.*;
import java.util.Scanner;

public class moviewatchlist {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String pass = "satyaparida";

        String sql = "INSERT INTO pratush (slno,movie_name,genere,rating,status) VALUES (?, ?, ?, ?, ?)";

        Scanner sc = new Scanner(System.in);
        System.out.println("choose any one option:");
        System.out.println("1.add movie to watchlist");
        System.out.println("2.update movie in watchlist");
        System.out.println("3.view your watchlist");
        System.out.println("4.delete movie from watchlist");
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("Welcome to the Movie Watchlist App!🎬\nLet's add some movies to your watchlist.🍿");        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            while(true){
            PreparedStatement ps = con.prepareStatement(sql);


            System.out.println("Enter slno🔄️:");
            ps.setInt(1, sc.nextInt());
            System.out.println("Enter movie name📽️:");
            ps.setString(2, sc.next());
            System.out.println("Enter genre🎞️:");
            ps.setString(3, sc.next());
            System.out.println("Enter rating✨:");
            ps.setFloat(4, sc.nextFloat());
            System.out.println("Enter status🗿:");
            ps.setString(5, sc.next());

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted");
            
            System.out.println("hey buddy do you want to add another movie,(yes/no)");
            String decision=sc.next();
            if(decision.equalsIgnoreCase("yes"))
                System.out.println("Alright👊, let's add another movie📽️!");
            else
                System.out.println("Thank you👍 for using our movie watchlist📽️ simulator");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        else if(choice==2){
            System.out.println("update your data");
            System.out.println("Enter the id of the movie to update:");
            sql ="update pratush set movie_name=?,genere=?,rating=?,status=? where slno=?";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, sc.next());
                ps.setString(2, sc.next());
                ps.setFloat(3, sc.nextFloat());
                ps.setString(4, sc.next());
                ps.setInt(5, sc.nextInt());
                int rows = ps.executeUpdate();
                System.out.println(rows + " record updated");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(choice==3){
            System.out.println("view your data");
            sql ="select * from pratush";
            try {
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getFloat(4));
                    System.out.println(rs.getString(5));
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(choice==4){
            System.out.println("delete your data");
            System.out.println("Enter the id of the movie to delete:");
            sql ="delete from pratush where slno=?";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, sc.nextInt());
                int rows = ps.executeUpdate();
                System.out.println(rows + " record deleted");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Invalid choice! Please select a valid option from the menu.");

        
        }
    }
}
