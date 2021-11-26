package pojo;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2021-11-17T23:59:21+0300"
)
public class InfoLinks implements java.io.Serializable {

    private String elon_twitter;
    private String flickr;
    private String twitter;
    private String website;

    public InfoLinks() {
    }

    public InfoLinks(String elon_twitter, String flickr, String twitter, String website) {
        this.elon_twitter = elon_twitter;
        this.flickr = flickr;
        this.twitter = twitter;
        this.website = website;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getElon_twitter() {
        return elon_twitter;
    }

    public void setElon_twitter(String elon_twitter) {
        this.elon_twitter = elon_twitter;
    }

    public String getFlickr() {
        return flickr;
    }

    public void setFlickr(String flickr) {
        this.flickr = flickr;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static class Builder {

        private String elon_twitter;
        private String flickr;
        private String twitter;
        private String website;

        public Builder() {
        }

        public Builder setElon_twitter(String elon_twitter) {
            this.elon_twitter = elon_twitter;
            return this;
        }

        public Builder setFlickr(String flickr) {
            this.flickr = flickr;
            return this;
        }

        public Builder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }


        public InfoLinks build() {
            return new InfoLinks(elon_twitter, flickr, twitter, website);
        }

    }
}
