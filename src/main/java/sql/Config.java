package sql;

class Config {

        public String getUrl() {
            return "jdbc:mysql://localhost/ads_db?serverTimezone=UTC&useSSL=false";
        }

        public String getUsername() {
            return "someuser";
        }

        public String getPassword() {
            return "strongpassword";
        }
}


