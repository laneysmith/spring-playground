package com.example;

import com.example.models.Album;
import com.example.repositories.AlbumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Collections;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)
public class RecordStoreControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AlbumRepository albumRepository;

    @Test
    public void testListAlbums() throws Exception {
        Long id = new Random().nextLong();
        Album album = new Album();
        album.setId(id);
        album.setArtist("Ji-Unit");
        album.setTitle("Riding in my Prius");

        when(this.albumRepository.findAll()).thenReturn(Collections.singletonList(album));

        MockHttpServletRequestBuilder request = get("/albums")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(id)))
                .andExpect(jsonPath("$[0].artist", equalTo("Ji-Unit")))
                .andExpect(jsonPath("$[0].title", equalTo("Riding in my Prius")));

    }

    @Test
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/albums")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Some Album\", \"artist\": \"Some Artist\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.artist", equalTo("Some Artist")))
                .andExpect(jsonPath("$.title", equalTo("Some Album")));

        verify(this.albumRepository).save(any(Album.class));
    }

}