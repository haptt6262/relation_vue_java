package com.example.testround3.Model.bo;

import com.example.testround3.Model.dto.CommentsDto;
import com.example.testround3.Model.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWithData {
    private String message;
    private Integer totalPage;
    private Object data;

    public ResponseWithData(String message, Object data) {
        this.message=message;
        this.data=data;
    }
}
