package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.services.impl.BookmarkServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmarkIntTests {
    @Autowired
    private BookmarkServiceImpl bookmarkServiceImpl;

    @Test
    public void testGetByDifferentIds() {
        assertNotNull(bookmarkServiceImpl.list());
        assertNotNull(bookmarkServiceImpl.getByRestId(2));
        assertNotNull(bookmarkServiceImpl.getByUserId(1));
        assertNotNull(bookmarkServiceImpl.getById(1));
    }

    @Test
    public void testGetCountByDifferentIds() {
        assertNotNull(bookmarkServiceImpl.countByUserId(1));
        assertNotNull(bookmarkServiceImpl.countByRestId(2));
    }

    @Test
    public void testBookmarkChange() {
        int retId;
        Bookmark bookmark = new Bookmark(0,1,1);

        assertTrue(bookmarkServiceImpl.save(bookmark));
        retId = bookmark.getMarkId();

        bookmark.setRestId(3);
        assertTrue(bookmarkServiceImpl.updateById(bookmark));

        assertTrue(bookmarkServiceImpl.removeById(retId));
        assertNull(bookmarkServiceImpl.getById(retId));
    }
}
