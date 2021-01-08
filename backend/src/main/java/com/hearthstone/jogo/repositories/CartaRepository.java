package com.hearthstone.jogo.repositories;

import com.hearthstone.jogo.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Long> {
}
