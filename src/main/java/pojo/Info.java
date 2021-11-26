package pojo;

import com.fasterxml.jackson.annotation.JsonRootName;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2021-11-17T23:59:21+0300"
)
@JsonRootName("company")
public class Info implements java.io.Serializable {

    private String ceo;
    private String coo;
    private String cto;
    private String cto_propulsion;
    private Integer employees;
    private Integer founded;
    private String founder;
    private Address headquarters;
    private Integer launch_sites;
    private InfoLinks links;
    private String name;
    private String summary;
    private Integer test_sites;
    private Double valuation;
    private Integer vehicles;

    public Info() {
    }

    public Info(String ceo, String coo, String cto, String cto_propulsion, Integer employees, Integer founded, String founder, Address headquarters, Integer launch_sites, InfoLinks links, String name, String summary, Integer test_sites, Double valuation, Integer vehicles) {
        this.ceo = ceo;
        this.coo = coo;
        this.cto = cto;
        this.cto_propulsion = cto_propulsion;
        this.employees = employees;
        this.founded = founded;
        this.founder = founder;
        this.headquarters = headquarters;
        this.launch_sites = launch_sites;
        this.links = links;
        this.name = name;
        this.summary = summary;
        this.test_sites = test_sites;
        this.valuation = valuation;
        this.vehicles = vehicles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getCto() {
        return cto;
    }

    public void setCto(String cto) {
        this.cto = cto;
    }

    public String getCto_propulsion() {
        return cto_propulsion;
    }

    public void setCto_propulsion(String cto_propulsion) {
        this.cto_propulsion = cto_propulsion;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Address getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(Address headquarters) {
        this.headquarters = headquarters;
    }

    public Integer getLaunch_sites() {
        return launch_sites;
    }

    public void setLaunch_sites(Integer launch_sites) {
        this.launch_sites = launch_sites;
    }

    public InfoLinks getLinks() {
        return links;
    }

    public void setLinks(InfoLinks links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getTest_sites() {
        return test_sites;
    }

    public void setTest_sites(Integer test_sites) {
        this.test_sites = test_sites;
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public Integer getVehicles() {
        return vehicles;
    }

    public void setVehicles(Integer vehicles) {
        this.vehicles = vehicles;
    }

    public static class Builder {

        private String ceo;
        private String coo;
        private String cto;
        private String cto_propulsion;
        private Integer employees;
        private Integer founded;
        private String founder;
        private Address headquarters;
        private Integer launch_sites;
        private InfoLinks links;
        private String name;
        private String summary;
        private Integer test_sites;
        private Double valuation;
        private Integer vehicles;

        public Builder() {
        }

        public Builder setCeo(String ceo) {
            this.ceo = ceo;
            return this;
        }

        public Builder setCoo(String coo) {
            this.coo = coo;
            return this;
        }

        public Builder setCto(String cto) {
            this.cto = cto;
            return this;
        }

        public Builder setCto_propulsion(String cto_propulsion) {
            this.cto_propulsion = cto_propulsion;
            return this;
        }

        public Builder setEmployees(Integer employees) {
            this.employees = employees;
            return this;
        }

        public Builder setFounded(Integer founded) {
            this.founded = founded;
            return this;
        }

        public Builder setFounder(String founder) {
            this.founder = founder;
            return this;
        }

        public Builder setHeadquarters(Address headquarters) {
            this.headquarters = headquarters;
            return this;
        }

        public Builder setLaunch_sites(Integer launch_sites) {
            this.launch_sites = launch_sites;
            return this;
        }

        public Builder setLinks(InfoLinks links) {
            this.links = links;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setTest_sites(Integer test_sites) {
            this.test_sites = test_sites;
            return this;
        }

        public Builder setValuation(Double valuation) {
            this.valuation = valuation;
            return this;
        }

        public Builder setVehicles(Integer vehicles) {
            this.vehicles = vehicles;
            return this;
        }


        public Info build() {
            return new Info(ceo, coo, cto, cto_propulsion, employees, founded, founder, headquarters, launch_sites, links, name, summary, test_sites, valuation, vehicles);
        }

    }
}
