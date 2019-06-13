package sql;

class Config {

        public String getUrl() {
            return "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false";
        }

        public String getUsername() {
            return "root";
        }

        public String getPassword() {
            return "codeup";
        }
}


