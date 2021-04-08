package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dto.CommentaireDto;
import fr.epsi.topaidi.viewmodel.CommentaireVM;

import java.util.List;

public interface CommentairesService {
    List<CommentaireVM> getAllByIdee(int idIdee);
    void create(CommentaireDto commentaireDto);
}
