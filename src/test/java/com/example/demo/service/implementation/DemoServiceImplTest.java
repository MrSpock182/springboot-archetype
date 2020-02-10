package com.example.demo.service.implementation;

import com.example.demo.domain.orm.Demo;
import com.example.demo.domain.dto.DemoRequest;
import com.example.demo.domain.dto.DemoResponse;
import com.example.demo.repository.DatabaseExternal;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DemoServiceImplTest {

    @Mock
    DatabaseExternal<Demo, Long> repository;

    @InjectMocks
    DemoService demoService = new DemoServiceImpl();

    private static final Long DEFAULT_ID = 1L;

    Demo demo;

    DemoRequest demoRequestDTO;

    DemoResponse demoResponseDTO;

    @BeforeEach
    void setupMockTests() {
        demo = new Demo();
        demo.setId(DEFAULT_ID);
        demo.setDemo("example");

        demoRequestDTO = DemoRequest.toDTO(demo);
        demoResponseDTO = DemoResponse.toDTO(demo);
    }

    @DisplayName("Test Mock demoService + demoRepository - Save")
    @Test
    void testSaveDemo() {
        when(repository.save(any(Demo.class)))
                .thenReturn(demo);

        DemoResponse save = demoService.save(demoRequestDTO);
        assertThat(save.getId()).isEqualTo(1L);
    }

//    @DisplayName("Test Mock demoService + demoRepository - Update")
//    @Test
//    void testUpdateDemo() {
//        when(repository.findById(eq(DEFAULT_ID)))
//                .thenReturn(Optional.of(demo));
//
//        Demo newDemo = new Demo();
//        newDemo.setId(DEFAULT_ID);
//        newDemo.setDemo("edited demo");
//
//        when(repository.save(eq(demo)))
//                .thenReturn(newDemo);
//
//        DemoRequest newDemoRequestDTO = DemoRequest.toDTO(newDemo);
//
//        DemoResponse update = demoService.update(DEFAULT_ID, newDemoRequestDTO);
//
//        assertThat(update.getId()).isEqualTo(1L);
//        assertThat(update.getDemo()).isEqualTo("edited demo");
//    }

//    @DisplayName("Test Mock demoService + demoRepository - Get One")
//    @Test
//    void testGetOne() {
//        when(repository.findById(eq(DEFAULT_ID)))
//                .thenReturn(Optional.of(demo));
//
//        DemoResponse found = demoService.findById(DEFAULT_ID);
//        assertThat(found.getId()).isEqualTo(1L);
//    }

//    @DisplayName("Test Mock demoService + demoRepository - Get All")
//    @Test
//    void testGetAll() {
//        PageRequest<DemoRequest> pageRequestDTO = new PageRequest<>();
//        pageRequestDTO.setPageSize(10);
//        pageRequestDTO.setPage(0);
//        pageRequestDTO.setOrderBy("Id");
//        pageRequestDTO.setDesc(Boolean.TRUE);
//
//        Page<Demo> page = new PageImpl<Demo>(Arrays.asList(demo));
//
//        when(repository.findAll(any(PageRequest.class)))
//                .thenReturn(page);
//
//        ListResponse<DemoResponse> items = demoService.findAll(pageRequestDTO);
//        assertThat(items.getTotalRegister()).isEqualTo(1L);
//    }
}
