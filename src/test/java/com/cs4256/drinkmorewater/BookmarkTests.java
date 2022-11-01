package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.BookmarkMapper;
import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.services.impl.BookmarkServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmarkTests {

    @Autowired
    private BookmarkServiceImpl bookmarkServiceImpl;

    @MockBean
    private BookmarkMapper bookmarkMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Bookmark retBookmark = new Bookmark(1, 1, 1);

        Mockito.when(bookmarkMapper.selectById(testId)).thenReturn(retBookmark);

        assertEquals(bookmarkServiceImpl.getById(testId), retBookmark);
    }

    @Test
    public void testGetAll() {
        List<Bookmark> bookmarkList = Arrays.asList(
                new Bookmark(1, 1, 1),
                new Bookmark(2, 2, 1));

        Mockito.when(bookmarkMapper.selectList(null)).thenReturn(bookmarkList);

        assertNotNull(bookmarkServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Bookmark updateBookmark = new Bookmark(1, 3,  1);

        Mockito.when(bookmarkMapper.updateById(updateBookmark)).thenReturn(1);

        assertTrue(bookmarkServiceImpl.updateById(updateBookmark));
    }

    @Test
    public void testInvalidUpdate() {
        Bookmark updateBookmark = new Bookmark(-1, 1, 1);

        Mockito.when(bookmarkMapper.updateById(updateBookmark)).thenReturn(0);

        assertFalse(bookmarkServiceImpl.updateById(updateBookmark));
    }

    @Test
    public void testAddBookmark() {
        Bookmark bookmarkToAdd = new Bookmark(2,1,1);

        Mockito.when(bookmarkMapper.insert(bookmarkToAdd)).thenReturn(1);

        assertTrue(bookmarkServiceImpl.save(bookmarkToAdd));
    }

    @Test
    public void testRemoveBookmark() {
        int removeId = 2;

        Mockito.when(bookmarkMapper.deleteById(removeId)).thenReturn(1);

        assertTrue(bookmarkServiceImpl.removeById(removeId));
    }
}
