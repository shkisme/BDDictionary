1. http://www.h2database.com/ 에 접속하여 다운받는다.
2. h2.sh를 실행한다.

### -bash: ./h2.sh: Permission denied 에러가 뜬다면

bin 폴더 경로에 가셔서 터미널 여시고

chmod 755 h2.sh    <-- 입력하시면 됩니다.

참고로 터미널에서는 h2 DB 종료 단축키는 control + c 입니다.

---

3. url에는 jdbc:h2:tcp://localhost/~/test 를 입력하고, 서버 모드로 H2 DB를 켠다.

### Database "" not found, either pre-create it or allow remote database creation 에러가 뜬다면

url에 jdbc:h2:~/test 를 입력하여 데이터베이스 파일을 생성해준다. 그 뒤로는 잘 접속이 될 것이다.

---

4. http://localhost:8082/ 에 접속하면 처음 접속 화면을 볼 수 있다.
