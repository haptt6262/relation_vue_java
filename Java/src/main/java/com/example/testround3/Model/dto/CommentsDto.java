package com.example.testround3.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Integer id;
    private String name_comment;
    private String name_post;
    private Integer id_post;
}
