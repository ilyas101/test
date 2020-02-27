package ru.karimov.sptnk.controler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.karimov.sptnk.model.Clothes;
import ru.karimov.sptnk.model.Size;
import ru.karimov.sptnk.service.ClothesService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ikarimov on 25.02.2020.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CothesControlerTest {

    @Autowired
    private ClothesController clothesController;

    @MockBean
    private ClothesService clothesService;

    private MockMvc mockMvc;

    private List<Clothes> clothesList;

    @Before
    public void initClothes(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(clothesController)
                .build();
        clothesList = new ArrayList<>();

        Clothes clothes = new Clothes();
        clothes.setId(1);
        clothes.setDesc("1");
        clothes.setSize(Size.SIZE_42);
        clothesList.add(clothes);

        clothes = new Clothes();
        clothes.setId(2);
        clothes.setDesc("2");
        clothes.setSize(Size.SIZE_44);
        clothesList.add(clothes);
    }

    @Test
    public void testGetAllClothesNotFound() throws Exception {
        clothesList.clear();
        given(this.clothesService.getAllClothes()).willReturn(clothesList);
        this.mockMvc.perform(get("/api/clothes/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllClothesSuccess() throws Exception {
        given(this.clothesService.getAllClothes()).willReturn(clothesList);
        this.mockMvc.perform(get("/api/clothes/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SIZE_42")))
                .andExpect(content().string(containsString("SIZE_44"))); // value("SIZE_42"));
    }
}
