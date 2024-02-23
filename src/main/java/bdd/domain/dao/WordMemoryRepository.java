package bdd.domain.dao;

import bdd.domain.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordMemoryRepository implements WordRepository {

  private final List<Word> words = new ArrayList<>();

  public void save(Word word) {
    this.words.add(word);
  }

  public Optional<Word> findByWord(String word) {
    return this.words.stream()
        .filter(w -> w.isMatch(word))
        .findFirst();
  }

  @Override
  public List<Word> findAll() {
    return words;
  }
}
