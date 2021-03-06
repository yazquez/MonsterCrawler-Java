package com.yazquez.monsterScraper.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class TextFileDataManagerTest {

    TextFileDataManager dataManager;

    @Before
    public void setUp() {
        // String fileName = getClass().getClassLoader().getResource("monsterCrawler-config.json").getFile();
        dataManager = new TextFileDataManager();
    }

    @Test
    public void ConfigurationShouldBeLoaded() {
        String configExpected = "Tecnologies:[ big-data-engineer spark hadoop mongodb scala cassandra angular ] - Places : [{country:'co.uk', city:''} {country:'co.uk', city:'london'} {country:'co.uk', city:'reading'} {country:'co.uk', city:'brighton'} {country:'co.uk', city:'belfast'} {country:'ie', city:''} {country:'ie', city:'dublin'} {country:'ie', city:'cork'} {country:'ie', city:'athlone'} {country:'ie', city:'galway'} ";
        String configLoaded = SearchConfigurationManager.getConfiguration().toString();

        assertEquals(configExpected, configLoaded);
    }

    @Test
    public void SearchsAreCorrectlyBuilded() {
        SearchEntity searchExpected = new SearchEntity("co.uk", "", "big-data-engineer");
        SearchEntity searchBuilded = dataManager.getSearchs().get(0);

        // assertEquals(searchExpected, searchBuilded);
        assertTrue(searchExpected.equals(searchBuilded));
    }

}
