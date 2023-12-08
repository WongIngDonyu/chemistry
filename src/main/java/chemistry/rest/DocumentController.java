package chemistry.rest;

import chemistry.DTO.DocumentFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import chemistry.models.DocumentFile;
import chemistry.service.DocumentService;


import java.util.List;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<DocumentFile> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/documents/search")
    public List<DocumentFile> getDocumentsByFileName(@RequestParam String file_name) {
        return documentService.getDocumentsByFileName(file_name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDocumentById(@PathVariable String id) {
        String htmlContent = documentService.getDocxContentAsHtml(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @PostMapping
    public DocumentFile addDocument(@RequestBody DocumentFileDto documentDto) {
        return documentService.addDocument(documentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String id) {
        return documentService.getDocumentById(id)
                .map(document -> {
                    documentService.deleteDocument(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}