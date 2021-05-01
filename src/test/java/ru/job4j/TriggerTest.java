package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marat Yanbaev
 * @create 01.05.2021
 */
public class TriggerTest {

    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }

}
