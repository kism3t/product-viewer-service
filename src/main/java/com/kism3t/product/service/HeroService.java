package com.kism3t.product.service;

import com.kism3t.product.model.Hero;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeroService {

    private static final Map<Integer, Hero> HEROES = new HashMap<Integer, Hero>();
    private static int nextHeroId = 21;

    {
        HEROES.put(11, new Hero(11, "Dr Nice"));
        HEROES.put(12, new Hero(12, "Narco"));
        HEROES.put(13, new Hero(13, "Bombasto"));
        HEROES.put(14, new Hero(14, "Celeritas"));
        HEROES.put(15, new Hero(15, "Magneta"));
        HEROES.put(16, new Hero(16, "RubberMan"));
        HEROES.put(17, new Hero(17, "Dynama"));
        HEROES.put(18, new Hero(18, "Dr IQ"));
        HEROES.put(19, new Hero(19, "Magma"));
        HEROES.put(20, new Hero(20, "Tornado"));
    }

    public Map<Integer, Hero> getHeroes() {
        return HEROES;
    }

    public Hero getHeroById(int heroId) {
        return HEROES.get(heroId);
    }

    public void updateHero(Hero hero) {
        if (HEROES.containsKey(hero.getId())) {
            Hero heroToUpdate = HEROES.get(hero.getId());
            heroToUpdate.setName(hero.getName());
        }
    }

    public Hero createHero(Hero hero) {
        if (!HEROES.containsKey(hero.getId())) {
            Hero createdHero = new Hero(nextHeroId, hero.getName());
            HEROES.put(nextHeroId, createdHero);
            nextHeroId++;
            return createdHero;
        }
        return HEROES.get(hero.getId());
    }

    public Hero deleteHero(Integer heroId) {
        return HEROES.remove(heroId);
    }
}
