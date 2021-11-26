package pojo;

public class Users implements java.io.Serializable {

    @javax.validation.constraints.NotNull
    private String id;
    private String name;
    private String rocket;
    @javax.validation.constraints.NotNull
    private String timestamp;
    private String twitter;

    public Users() {
    }

    public Users(String id, String name, String rocket, String timestamp, String twitter) {
        this.id = id;
        this.name = name;
        this.rocket = rocket;
        this.timestamp = timestamp;
        this.twitter = twitter;
    }

    public static Users.Builder builder() {
        return new Users.Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public static class Builder {

        private String id;
        private String name;
        private String rocket;
        private String timestamp;
        private String twitter;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRocket(String rocket) {
            this.rocket = rocket;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }


        public Users build() {
            return new Users(id, name, rocket, timestamp, twitter);
        }

    }
}