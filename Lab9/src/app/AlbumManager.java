package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args){

        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        Artist artist = new Artist();
        artist.setName("name");
        artist.setCountry("country");

        Album album = new Album();
        album.setName("album");
        album.setArtistId(1);
        album.setReleaseYear(2020);

        artistRepository.create(artist);
        albumRepository.create(album);

        System.out.println(artistRepository.findByName("50cent"));
        System.out.println(albumRepository.findByArtist(1));

    }
}