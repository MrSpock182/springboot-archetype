package com.example.demo.domain.dto;

import com.example.demo.domain.orm.Demo;

public class DemoResponse {

    private Long id;

    private String demo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "DemoResponse{" +
                "id=" + id +
                ", demo='" + demo + '\'' +
                '}';
    }

    public static DemoResponse toDTO(Demo demo) {
        DemoResponse demoResponseDTO = new DemoResponse();
        demoResponseDTO.setId(demo.getId());
        demoResponseDTO.setDemo(demo.getDemo());

        return demoResponseDTO;
    }

    public static Demo fromDTO(DemoResponse demoResponseDTO) {
        Demo demo = new Demo();
        demo.setId(demoResponseDTO.getId());
        demo.setDemo(demoResponseDTO.getDemo());

        return demo;
    }
}
