package com.kism3t.product.controller;

import com.kism3t.product.model.Hero;
import com.kism3t.product.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public Collection<Hero> getHeroes() {
        return heroService.getHeroes().values();
    }

    @GetMapping("/{heroId}")
    public Hero getHero(@PathVariable int heroId) {
        return heroService.getHeroById(heroId);
    }

    @PutMapping()
    public void updateHero(@RequestBody(required = true) Hero hero) {
        heroService.updateHero(hero);
    }

    @PostMapping
    public Hero createHero(@RequestBody(required = true) Hero hero) {
        return heroService.createHero(hero);
    }

    @DeleteMapping("/{heroId}")
    private Hero deleteHero(@PathVariable int heroId){
        return heroService.deleteHero(heroId);
    }
}
