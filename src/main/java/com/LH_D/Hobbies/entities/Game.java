package com.LH_D.Hobbies.entities;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "game_genre",
			joinColumns = @JoinColumn(name = "game_id"),
			inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private List<Genre> genres;
	
	@Column(name = "game_year")
	private Integer year;
	private String platforms;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	private String imgUrl;
	
	
	public Game() {
	}

	public Game(Long id, String name, List<Genre> genres, Integer year, String genre, String platforms, String description, String imgUrl) {
		this.id = id;
		this.name = name;
		this.genres = genres;
		this.year = year;
		this.platforms = platforms;
		this.description = description;
		this.imgUrl = imgUrl;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenres() {
		return genres.stream().map(Object::toString).collect(Collectors.joining(", "));
	}

	public void setGenres(List<Genre> genre) {
		
		this.genres = genre;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getPlatforms() {
		return platforms;
	}

	public void setPlatform(String platforms) {
		this.platforms = platforms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
}
