package com.codenjoy.dojo.expansion.model.levels;

/*-
 * #%L
 * expansion - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2017 EPAM
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.expansion.model.Expansion;
import com.codenjoy.dojo.expansion.model.GameFactory;
import com.codenjoy.dojo.expansion.model.PlayerBoard;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.expansion.model.replay.GameLoggerImpl;

/**
 * Created by Oleksandr_Baglai on 2017-09-01.
 */
public class OneMultipleGameFactory implements GameFactory {

    private Dice dice;
    private LevelsFactory singleFactory;
    private LevelsFactory multipleFactory;

    private PlayerBoard multiple;

    public OneMultipleGameFactory(Dice dice,
                                  LevelsFactory singleFactory,
                                  LevelsFactory multipleFactory) {
        this.dice = dice;
        this.singleFactory = singleFactory;
        this.multipleFactory = multipleFactory;
    }

    @Override
    public PlayerBoard existMultiple() {
        return multiple;
    }

    @Override
    public PlayerBoard newMultiple() {
        return multiple = new Expansion(multipleFactory.get(), dice, new GameLoggerImpl(), Expansion.MULTIPLE);
    }

    @Override
    public PlayerBoard single() {
        return new Expansion(singleFactory.get(), dice, new GameLoggerImpl(), Expansion.SINGLE);
    }
}
