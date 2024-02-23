package demo;

import java.util.ArrayList;
import java.util.List;

public class Word {

  private String name;

  private final List<Mean> means = new ArrayList<>();

  public Word(String name, Language language, String mean) {
    this.name = name;
    this.means.add(new Mean(language, mean));
  }

  public String getMean(Language language) {
    Mean mean = means.stream()
        .filter(m -> m.isLanguage(language))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("%s 언어에 대응하는 뜻은 없습니다.".formatted(language)));
    return mean.getName();
  }

  public boolean isMatch(String word) {
    return this.name.equals(word);
  }

  public boolean existLanguage(Language language) {
    return means.stream()
        .anyMatch(mean -> mean.isLanguage(language));
  }

  public String convert(Language language) {
    Mean mean = this.means.stream()
        .filter(m -> m.isLanguage(language))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("%s언어로 등록된 해당 단어는 없습니다.".formatted(language)));
    return mean.getName();
  }
}
