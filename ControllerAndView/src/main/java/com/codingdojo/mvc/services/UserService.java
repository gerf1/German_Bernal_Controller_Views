package com.codingdojo.mvc.services;

import com.codingdojo.mvc.services.*;
import com.codingdojo.mvc.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.*;


@Service
public class UserService {
	private final LookifyRepository lookifyRepository;
	
	public UserService(LookifyRepository lookifyRepository ) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Song> allSongs() {
		return lookifyRepository.findAll();
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookifyRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        }
        else {
            return null;
        }
	}
	
	public Song addSong(Song melody) {
		return lookifyRepository.save(melody);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public List<Song> getTopTen(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	
	public List<Song> getSearchSongs(String artist){
		return lookifyRepository.findByArtist(artist);
	}
}