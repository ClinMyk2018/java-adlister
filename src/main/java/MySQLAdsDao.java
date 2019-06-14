import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;


    public MySQLAdsDao() {
        try {
            Config config = new Config();
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    private Ad getAdsResults(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> AdsResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(getAdsResults(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> all() {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return AdsResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error retrieving ads", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
//        long Id = ad.getUserId();
//        String Title = ad.getTitle();
//        String Desc = ad.getDescription();
        String insertNew = "INSERT INTO ads( user_id, title, description) VALUES (2, 'Bank Downfall', 'Big time losses')";
        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(insertNew, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new Ad! New Ad ID: " + rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("error inserting ads", e);
        }

        return null;
    }



}
