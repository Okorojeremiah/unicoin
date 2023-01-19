package africa.semicolon.unicoin.utiils;

import lombok.*;

import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ApiResponse {
    private ZonedDateTime timeStamp;
    private int statusCode;
    private String path;
    private  Object data;
    private Boolean isSuccessful;
}
