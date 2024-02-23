package bdd.service;

import bdd.domain.dao.Language;
import bdd.domain.Word;
import bdd.domain.dao.WordRepository;
import java.util.Optional;

public abstract class Dictionary {

  private final WordRepository wordRepository;

  public Dictionary(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  protected void create(String wordName, String meanName, Language language) {
    validateDuplicate(wordName, language);
    validateWord(meanName);
    Word word = new Word(wordName, language, meanName);
    wordRepository.save(word);
  }

  protected void validateDuplicate(String word, Language language) {
    Optional<Word> findWord = wordRepository.findByWord(word);
    if (findWord.isEmpty()) {
      return;
    }
    if (findWord.get().existLanguage(language)) {
      throw new IllegalArgumentException("이미 해당 단어의 뜻이 %s로 존재합니다.".formatted(findWord.get().convert(language)));
    }
  }

  protected abstract void validateWord(String meanName);

  protected String convert(String word, Language language) {
    Word findWord = wordRepository.findByWordAndLanguage(word, language)
        .orElseThrow(() -> new IllegalArgumentException("%s 언어로 등록된 %s 단어는 없습니다.".formatted(language, word)));
    return findWord.convert(language);
  }
}
