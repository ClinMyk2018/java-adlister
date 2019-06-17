import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;


    public MySQLAdsDao() {
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public MySQLAdsDao(String sql) throws SQLException {
        Config config = new Config();
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
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
    public Long insert(Ad ad) throws SQLException {
        String add = addAd(ad);
        Statement stmt;
            stmt = connection.createStatement();
            stmt.executeUpdate(add, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new Ad! New Ad ID: " + rs.getLong(1));
            }

        return null;
    }


    public String addAd(Ad ad) throws SQLException {
        long UserId = ad.getUserId();
        String Title = ad.getTitle();
        String Desc = ad.getDescription();
        String sql = String.format("INSERT INTO ads( user_id, title, description)" +
                " VALUES (%d, '%s', '%s')" ,UserId, Title, Desc);
        new MySQLAdsDao(sql);
        return sql;
    }

    @Override
    public long delete(Ad ad) throws SQLException {
        String delete = deleteAd(ad);
        Statement stmt;
        stmt = connection.createStatement();
        stmt.executeUpdate(delete, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Deleted an Ad!");
        }

        return Long.parseLong("");
    }

    public String deleteAd(Ad ad) throws SQLException {
        long Id = ad.getId();
        String sql = String.format("DELETE FROM ads WHERE id = (%d)" ,Id);
        new MySQLAdsDao(sql);
        return sql;
    }

}
