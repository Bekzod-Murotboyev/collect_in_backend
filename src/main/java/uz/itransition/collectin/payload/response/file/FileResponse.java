package uz.itransition.collectin.payload.response.file;

import lombok.*;
import uz.itransition.collectin.payload.response.Response;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse implements Response {
    List<String> path;
}
