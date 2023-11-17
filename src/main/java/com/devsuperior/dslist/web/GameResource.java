package com.devsuperior.dslist.web;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameResource {
    private final GameService gameService;
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getGames(){
        return gameService.getGames().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(gameService.getGames());
    }
}
