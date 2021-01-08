package com.hearthstone.jogo.controller;

import com.hearthstone.jogo.dto.CartaDTO;
import com.hearthstone.jogo.model.Carta;
import com.hearthstone.jogo.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carta")
public class CartaController {

    @Autowired
    private CartaService service;

    @PostMapping
    @RequestMapping("/filtrar")
    public List<Carta> filtrar(@RequestBody CartaDTO dto){
        return  service.pesquisar(dto);
    }

    @GetMapping
    public ResponseEntity<List<CartaDTO>> consultar() {
        List<CartaDTO> list = service.consultar();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CartaDTO> cadastrar(@RequestBody CartaDTO dto) {
        dto = service.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartaDTO> delete(@PathVariable Long id) {
        CartaDTO dto = service.delete(id);
        return ResponseEntity.ok().body(dto);
    }
}
