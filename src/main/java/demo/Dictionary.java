package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dictionary {

  private final List<Word> words = new ArrayList<>();

  public void create(String wordName, String meanName, Language language) {
    validateDuplicate(wordName, language);
    // TODO 각 언어에 따른 제약 추가
    Word word = new Word(wordName, language, meanName);
    Word opponentWord = new Word(meanName, language, wordName);
    this.words.add(word);
    this.words.add(opponentWord);
  }

  private void validateDuplicate(String word, Language language) {
    Optional<Word> findWord = this.words.stream()
        .filter(w -> w.isMatch(word))
        .findFirst();
    if (findWord.isEmpty()) {
      return;
    }
    if (findWord.get().existLanguage(language)) {
      throw new IllegalArgumentException("이미 해당 단어의 뜻이 %s로 존재합니다.".formatted(findWord.get().convert(language)));
    }
  }

  public String convert(String word, Language language) {
    Word findWord = this.words.stream()
        .filter(w -> w.isMatch(word))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("%s 언어로 등록된 %s 단어는 없습니다.".formatted(language, word)));
    return findWord.convert(language);
  }
}
