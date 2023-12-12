package chemistry.service;

import chemistry.DTO.DocumentFileDto;
import chemistry.models.Users;
import chemistry.service.repository.UsersRepository;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import chemistry.models.DocumentFile;
import chemistry.service.repository.DocumentRepository;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final UsersRepository userRepository;

    public DocumentService(DocumentRepository documentRepository, UsersRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    public List<DocumentFile> getAllDocuments() {
        return documentRepository.findAll();
    }

    /*public List<DocumentFile> getDocumentsByFileName(String file_name) {
        return documentRepository.findByFileName(file_name);
    }*/

    public DocumentFile addDocument(DocumentFileDto documentDto) {
        DocumentFile document = new DocumentFile();
        document.setFilePath(documentDto.getFilePath());

        Users user = userRepository.findById((long) Math.toIntExact(documentDto.getUserId())).orElse(null);
        /*.orElseThrow(() -> new RuntimeException("User not found"))*/;
        document.setUser(user);
        document.setFileName(documentDto.getFileName());
        document.setImagePath(documentDto.getImagePath());

        return documentRepository.save(document);
    }

    public DocumentFile updateDocument(String id, DocumentFile updatedDocument) {
        return documentRepository.findById(id)
                .map(document -> {
                    document.setFilePath(updatedDocument.getFilePath());
                    return documentRepository.save(document);
                })
                .orElseGet(() -> {
                    updatedDocument.setId(Integer.parseInt(id));
                    return documentRepository.save(updatedDocument);
                });
    }

    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }

    public Optional<DocumentFile> getDocumentById(String id) {
        return documentRepository.findById(id);
    }

    public String getDocxContentAsHtml(String id) {
        Optional<DocumentFile> documentFile = documentRepository.findById(id);
        if (documentFile.isPresent()) {
            String filePath = documentFile.get().getFilePath();
            try (FileInputStream fis = new FileInputStream(new File(filePath));
                 XWPFDocument document = new XWPFDocument(OPCPackage.open(fis))) {
                XHTMLOptions options = XHTMLOptions.create();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                XHTMLConverter.getInstance().convert(document, baos, options);
                return new String(baos.toByteArray(), StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error converting document: " + e.getMessage();
            }
        }
        return "Document not found";
    }
    public String getDocxContentAsHtmlByName(String id) {
        Optional<DocumentFile> documentFile = documentRepository.findByFileName(id);
        if (documentFile.isPresent()) {
            String filePath = documentFile.get().getFilePath();
            try (FileInputStream fis = new FileInputStream(new File(filePath));
                 XWPFDocument document = new XWPFDocument(OPCPackage.open(fis))) {
                XHTMLOptions options = XHTMLOptions.create();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                XHTMLConverter.getInstance().convert(document, baos, options);
                return new String(baos.toByteArray(), StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error converting document: " + e.getMessage();
            }
        }
        return "Document not found";
    }
}