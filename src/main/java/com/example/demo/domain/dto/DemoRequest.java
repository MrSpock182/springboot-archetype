package com.example.demo.domain.dto;

import com.example.demo.domain.orm.Demo;

public class DemoRequest {

    public String demo;

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "DemoRequest{" +
                "demo='" + demo + '\'' +
                '}';
    }

    public static DemoRequest toDTO(Demo demo) {
        DemoRequest demoRequestDTO = new DemoRequest();
        demoRequestDTO.setDemo(demo.getDemo());

        return demoRequestDTO;
    }

    public static Demo fromDTO(DemoRequest demoRequestDTO) {
        Demo demo = new Demo();
        demo.setDemo(demoRequestDTO.getDemo());

        return demo;
    }
}
