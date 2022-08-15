package com.example.testround3.Model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentsIn {
    private Integer id;
    private String name_comment;
    private Integer id_post;
}
