package peaksoft.dtohomework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class SimpleResponse {
    HttpStatus httpStatus;
    String message;


}
