package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void nameDoesNotChange() {
        Item[] items = new Item[] { new Item("Wacky name", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Wacky name", app.items[0].name);
    }

    @Test
    void nonCannonItemExpectedBehavior() {
        Item[] items = new Item[] { new Item("Wacky name", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals( -2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void SulfurasExpectedBehavior() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals( 3, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
        app.updateQuality();
        assertEquals( 3, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void AgedBrieExpectedBehavior() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        app.updateQuality();
        assertEquals( -2, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void BackstagePassExpectedBehavior() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals( 4, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
        app.updateQuality();
        assertEquals( 3, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void JointExpectedBehavior() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 3),
            new Item("Sulfuras, Hand of Ragnaros", 8, 3)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(8, app.items[1].sellIn);
    }

    @Test
    void DoesNothingExpectedBehavior() {
        GildedRose app = new GildedRose(new Item[]{});
        app.updateQuality();
        assertEquals(0, app.items.length);
    }

    @Test
    void SulfurasNegativeBehavior() {
        GildedRose app = new GildedRose(new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 8, 3) });
        app.updateQuality();
        assertNotEquals(7, app.items[0].sellIn);
    }

    @Test
    void BackstagePassBoundaryBehaviorHi() {
        GildedRose app = new GildedRose(new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 6, 3) });
        app.updateQuality();
        assertNotEquals(8, app.items[0].sellIn);
    }

    @Test
    void BackstagePassBoundaryBehaviorLo() {
        GildedRose app = new GildedRose(new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3) });
        app.updateQuality();
        assertNotEquals(9, app.items[0].sellIn);
    }
}

