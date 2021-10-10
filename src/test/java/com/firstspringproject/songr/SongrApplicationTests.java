package com.firstspringproject.songr;

import com.firstspringproject.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class SongrApplicationTests {

	@Test public void constructorTest() {
		Album album1 = new Album("Night Life", "Sara Lovell", 4, 180, "https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605");
			assertEquals("Album{title='Night Life', artist='Sara Lovell', songCount=4, length=180, imageUrl='https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605'}",album1.toString());
		}

	@Test public void gettersTest() {
		Album album1 = new Album("Night Life", "Sara Lovell", 4, 180, "https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605");
		assertEquals("Night Life",album1.getTitle());
		assertEquals("Sara Lovell",album1.getArtist());
		assertEquals(4,album1.getSongCount());
		assertEquals(180,album1.getLength());
		assertEquals("https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605",album1.getImageUrl());
	}

	@Test public void settersTest() {
		Album album1 = new Album("Night Life", "Sara Lovell", 4, 180, "https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605");
		album1.setTitle("song title");
		album1.setArtist("songer");
		album1.setSongCount(2);
		album1.setLength(360);
		album1.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfyr5DHD8gOjWaawbvWxlv9HQKie0m4xetQw&usqp=CAU");
		assertEquals("Album{title='song title', artist='songer', songCount=2, length=360, imageUrl='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfyr5DHD8gOjWaawbvWxlv9HQKie0m4xetQw&usqp=CAU'}",album1.toString());
	}


}
