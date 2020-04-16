package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "artists", schema = "musicalbums")
@NamedQueries({
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artist a WHERE a.name=:name")})
public class Artist {
    private int id;
    private String name;
    private String country;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
