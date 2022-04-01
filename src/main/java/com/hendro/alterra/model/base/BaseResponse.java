package com.hendro.alterra.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {


    @Serial
    private static final long serialVersionUID = 1265387159828381788L;

    private LocalDateTime timestamp;

    private String responseCode;

    private String message;

    private Object data;
}