package uz.itransition.collectin.controller.collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import uz.itransition.collectin.payload.request.comment.CommentCreationRequest;
import uz.itransition.collectin.payload.response.APIResponse;
import uz.itransition.collectin.payload.response.comment.CommentResponse;
import uz.itransition.collectin.service.comment.CommentService;

import static uz.itransition.collectin.controller.ControllerUtils.COMMENT_URI;

@RestController
@RequestMapping(COMMENT_URI)
public class CommentController {

    private final CommentService commentService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public CommentController(CommentService commentService, SimpMessagingTemplate simpMessagingTemplate) {
        this.commentService = commentService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping()
    public ResponseEntity<Void> sendMessage(@RequestBody CommentCreationRequest request) {
        simpMessagingTemplate.convertAndSend("/topic/comments/" + request.getItemId(), commentService.create(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/item/{id}")
//    public ResponseEntity<APIResponse> getComments(@PathVariable Long id) {
//        return ResponseEntity.ok(commentService.getCommentsByItemId(id));
//    }
//
//    @MessageMapping("/item")
//    @SendTo("/topic/comments")
//    public ResponseEntity<APIResponse> sendComment(
//            @Payload CommentCreationRequest comment
//    ) {
//        return ResponseEntity.ok(commentService.create(comment));
//    }
}
