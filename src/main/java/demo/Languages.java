package demo;

import java.util.ArrayList;
import java.util.List;

public class Languages {

  private final List<Language> languages = new ArrayList<>();

  public void add(Language language) {
    this.languages.add(language);
  }

  public Language chose(String name) {
    return languages.stream()
        .filter(language -> language.isMatch(name))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 언어는 없습니다."));
  }
}
