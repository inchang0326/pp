package com.example.pp.controller;

import com.example.pp.dto.FruitDto;
import com.example.pp.entity.Apple;
import com.example.pp.mapper.DtoMapper;
import com.example.pp.service.FruitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(FruitController.class)
@AutoConfigureRestDocs
class FruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FruitService fruitService;

//    @InjectMocks
//    private FruitService fruitService;

//    @Autowired
//    private FruitController fruitController;
//
//    @Autowired
//    private FruitService fruitService;

    @Test
    public void FruitControllergetTest2() throws Exception {
//        this.mockMvc.perform(get("/fruit/get")).andExpect(status().isOk()).andDo(print());
        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/fruit/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo( // Rest Docs 문서 작성 시작
                        document("fruit-get",
                                pathParameters( // path 파라미터 정보 입력
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("fruitName").description("FruitName"),
                                        fieldWithPath("fruitPrice").description("FruitPrice")
                                )
                        )
                )
        ;
//        System.out.println(fruitController.get());
    }
}