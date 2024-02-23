package bdd.domain.dao;

import bdd.domain.Word;
import java.util.List;
import java.util.Optional;

public interface WordRepository {

  void save(Word word);

  Optional<Word> findByWord(String word);

  List<Word> findAll();
}
