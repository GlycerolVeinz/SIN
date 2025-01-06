package priv.sin.librarylabsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;

@Service
public class ContractFacadeServiceImpl implements ContractFacadeService{
    PublisherService publisherService;
    AuthorService authorService;

    @Autowired
    public ContractFacadeServiceImpl(PublisherService publisherService, AuthorService authorService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void makeContract(Integer authorId, Integer publisherId) {
        Publisher publisher = publisherService.findById(publisherId);
        Author author = authorService.findById(authorId);

        publisher = publisherService.updateContract(publisher, author);
        author = authorService.updateContract(author, publisher);

        if (!(author != null && publisher != null)) {
            throw new RuntimeException(
                    String.format("Failed to make contract between author %d and publisher %d",
                            authorId,
                            publisherId));
        }
    }
}
