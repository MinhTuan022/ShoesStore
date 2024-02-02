package com.example.shoesstore.Model.Requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    private String cmtContent;
    private String cmtDate;
    private boolean cmtState;
    private long proId;
    private long uId;
}
