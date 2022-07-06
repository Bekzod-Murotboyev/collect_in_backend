package uz.itransition.collectin.controller.collection;

import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itransition.collectin.controller.AbstractCRUDController;
import uz.itransition.collectin.payload.request.collection.TopicRequest;
import uz.itransition.collectin.payload.response.APIResponse;
import uz.itransition.collectin.payload.response.collection.TopicResponse;
import uz.itransition.collectin.service.collection.TopicService;

import java.util.List;

import static uz.itransition.collectin.controller.ControllerUtils.*;

@RestController
@RequestMapping(TOPIC_URI)
public class TopicController extends AbstractCRUDController<TopicService, Long, TopicRequest, TopicRequest> {
    protected TopicController(TopicService service) {
        super(service);
    }


    @GetMapping
    public ResponseEntity<APIResponse> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
