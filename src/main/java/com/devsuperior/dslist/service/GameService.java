package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.model.Game;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDTO> getGames() {
        var games = gameRepository.findAll();

        if(!games.isEmpty())
            return games.stream().map(GameDTO::new).toList();

        return Collections.emptyList();
    }
}
